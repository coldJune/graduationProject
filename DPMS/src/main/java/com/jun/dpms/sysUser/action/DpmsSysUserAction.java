
package com.jun.dpms.sysUser.action;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.http.client.support.HttpAccessor;

import com.jun.dpms.sysUser.bean.DpmsSysUser;
import com.jun.dpms.sysUser.service.IDpmsSysUserService;
import com.jun.dpms.util.MD5Util;
import com.jun.dpms.util.SecurityCode;
import com.jun.dpms.util.SendMail;
import com.jun.dpms.util.pagecut.bean.Page;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 
 * @author coldJune
 * 用户管理的Action
 */
public class DpmsSysUserAction extends ActionSupport implements ModelDriven{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7357031286250160066L;
	private IDpmsSysUserService dpmsSysUserService;
	private DpmsSysUser dpmsSysUser=new DpmsSysUser();
	private Page page = new Page();
	private List<DpmsSysUser> dpmsSysUsers;
	private String userNames[];
	private File imgHead;
	private String imgHeadFileName;
	private String imgHeadContentType;
	private InputStream imageStream;
	private Map sessionMap;
	public List<DpmsSysUser> getDpmsSysUsers() {
		return dpmsSysUsers;
	}

	public void setDpmsSysUsers(List<DpmsSysUser> dpmsSysUsers) {
		this.dpmsSysUsers = dpmsSysUsers;
	}

	public IDpmsSysUserService getDpmsSysUserService() {
		return dpmsSysUserService;
	}

	public void setDpmsSysUserService(IDpmsSysUserService dpmsSysUserService) {
		this.dpmsSysUserService = dpmsSysUserService;
	}
	/*
	 * 查询所有的数据
	 */
	public String findAll(){
		page.setEachPage(5);
		page.setTotalItem(dpmsSysUserService.getTotalItem());
		page.setTotalPage(page.getTotalItem()/page.getEachPage()+(page.getTotalItem()%page.getEachPage()>0?1:0));
		try{
			page.setCurrentPage(Integer.valueOf((ServletActionContext.getRequest().getParameter("currentPage"))).intValue());
		}catch(Exception e){
			page.setCurrentPage(1);
		}
		dpmsSysUsers=dpmsSysUserService.findAll(page.getEachPage(),page.getCurrentPage());
		return SUCCESS;
	}
	/**
	 * 通过用户名查找
	 * @return
	 */
	public String searchByUserName(){
		dpmsSysUsers.clear();
		dpmsSysUsers.add(dpmsSysUserService.searchByUserName(((DpmsSysUser)getModel()).getUserName()));
		return SUCCESS;
	}
	
	/**
	 * 显式详细信息页面
	 */
	public String showDetail(){
		dpmsSysUser=dpmsSysUserService.searchByUserName(dpmsSysUser.getUserName());
		return SUCCESS;
	}
	/**
	 * 更新系统用户信息
	 */
	public String update(){
		System.out.println(ServletActionContext.getRequest().getParameter("type"));
		if(ServletActionContext.getRequest().getParameter("type").equals("personal")){
			dpmsSysUserService.updateSysUser(dpmsSysUser);
			Map<String, String> map= new HashMap<>();
			map.put("msg", "修改成功");
			setSessionMap(map);
			return "personal";
		}else{
			dpmsSysUserService.updateSysUser(dpmsSysUser);
			return SUCCESS;
		}
		
	}
	
	/*
	 * 跳转到添加页面
	 */
	public String addB(){
		return SUCCESS;
	}
	/**
	 * 添加系统用户信息
	 * @return
	 */
	public String add(){
		DpmsSysUser dpmsSysUser = (DpmsSysUser)getModel();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate=df.format(new Date());
		String passWord=SecurityCode.getSecurityCode();
		String md5pass=MD5Util.encode2hex(passWord);
		dpmsSysUser.setCreateDate(createDate);
		dpmsSysUser.setIsUse(1);
		dpmsSysUser.setIsSysPass(1);
		dpmsSysUser.setPassWord(md5pass);
		dpmsSysUser.setLastLogin(null);
		dpmsSysUserService.addSysUser(dpmsSysUser);
		SendMail.send(dpmsSysUser.getEmail(), "DPMS<br>您的密码为<strong>"+passWord+"</strong>,请尽快登录系统更改");
		return SUCCESS;
	}
	/**
	 * 逻辑删除用户信息
	 * @return
	 */
	public String del(){
		dpmsSysUserService.delSysUser(userNames);
		return SUCCESS;
	}
	
	/**
	 * 上传图片
	 */
	
	public String uploadImg(){
		try {
			InputStream is = new FileInputStream(imgHead);
			String userName=(String)ServletActionContext.getRequest().getSession().getAttribute("USERNAME");
			String fileName=userName+imgHeadFileName.substring(imgHeadFileName.lastIndexOf('.'), imgHeadFileName.length());
			String savePath=this.getClass().getClassLoader().getResource("").getPath();
			savePath=savePath.split("WEB-INF/classes")[0]+"head/";
			File myPath=new File(savePath);
			if(!myPath.exists()){
				myPath.mkdir();
			}
			BufferedImage bufImg=ImageIO.read(is);
			//原始宽度
			int old_w=bufImg.getWidth();
			//原始高度
			int old_h=bufImg.getHeight();
			//压缩后图片宽度
			int imageW;
			//压缩后图片高度
			int imageH;
			BufferedImage squarePic;//正方形
			if(old_w>old_h){
				squarePic=new BufferedImage(old_w, old_w, BufferedImage.TYPE_INT_BGR);
			}else if(old_w<old_h){
				squarePic=new BufferedImage(old_h, old_h, BufferedImage.TYPE_INT_RGB);
			}else{
				squarePic=new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
			}
			Graphics2D g =squarePic.createGraphics();
			g.setColor(Color.BLACK);
			if(old_w>old_h){
				g.fillRect(0, 0, old_w, old_w);
				g.drawImage(bufImg, 0, (old_w-old_h)/2,old_w, old_h,Color.BLACK,null);
			}else{
				if(old_w<old_h){
					g.fillRect(0, 0, old_h, old_h);
					g.drawImage(bufImg, (old_h-old_w)/2, 0, old_w,old_h, Color.BLACK,null);
				}else{
					g.drawImage(bufImg.getScaledInstance(old_w, old_h, Image.SCALE_SMOOTH), 0, 0,null);
				}
			}
			g.dispose();
			bufImg=squarePic;
			old_h=bufImg.getHeight();
			old_w=bufImg.getHeight();
			if(old_w>=old_h){
				imageW=800;
				imageH=(int)Math.round((old_h*imageW*1.0/old_w));
			}else{
				imageH=600;
				imageW=(int)Math.round((old_w*imageH*1.0/old_h));
			}
			BufferedImage newImage= new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
			newImage.getGraphics().drawImage(bufImg.getScaledInstance(imageH, imageW, Image.SCALE_SMOOTH),0,0,null);
			String imgPath=savePath+fileName;

			OutputStream os = new FileOutputStream(imgPath);
			ImageIO.write(newImage, "PNG", os);

			/*byte[] buffer = new byte[1024];
			int count=0;
			while((count = is.read(buffer)) > 0){
				os.write(buffer, 0, count);
			}*/
			newImage.flush();
			os.flush();
			os.close();
			is.close();
			dpmsSysUser.setImgPath(imgPath);
			dpmsSysUser.setUserName(userName);
			dpmsSysUserService.updateImg(dpmsSysUser);
		} catch (Exception e) {
			// TODO: handle exception
			Map<String, String> map = new HashMap<>();
			map.put("false", "上传失败");
			setSessionMap(map);
		}
		return SUCCESS;
	}
	/**
	 * 显示图片
	 * @return
	 */
	public String showHead(){
		try {
			String userName=(String) ServletActionContext.getRequest().getSession().getAttribute("USERNAME");
			imageStream=new FileInputStream(new File(dpmsSysUserService.searchByUserName(userName).getImgPath()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读取出错");
		}
		return SUCCESS;
	}
	
	public String showPersonal(){
		dpmsSysUser = dpmsSysUserService.searchByUserName(dpmsSysUser.getUserName());
		return SUCCESS;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dpmsSysUser;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		
		this.page=page;
	}

	public DpmsSysUser getDpmsSysUser() {
		return dpmsSysUser;
	}

	public void setDpmsSysUser(DpmsSysUser dpmsSysUser) {
		this.dpmsSysUser = dpmsSysUser;
	}

	public String[] getUserNames() {
		return userNames;
	}

	public void setUserNames(String[] userNames) {
		this.userNames = userNames;
	}
	@JSON(serialize=false)
	public File getImgHead() {
		return imgHead;
	}

	public void setImgHead(File imgHead) {
		this.imgHead = imgHead;
	}

	public Map getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map sessionMap) {
		this.sessionMap = sessionMap;
	}

	public String getImgHeadContentType() {
		return imgHeadContentType;
	}

	public void setImgHeadContentType(String imgHeadContentType) {
		this.imgHeadContentType = imgHeadContentType;
	}

	public String getImgHeadFileName() {
		return imgHeadFileName;
	}

	public void setImgHeadFileName(String imgHeadFileName) {
		this.imgHeadFileName = imgHeadFileName;
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}


	
	
}
