package action.common;

import hib.ora.entity.Userinfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import action.AbstractJsonLogAction;
import action.config.SystemConStants;

public class CreateUserFile  extends AbstractJsonLogAction {
	
	public String writeFile(Userinfo userinfo) {
		OutputStreamWriter out=null;
		before();

		try{
			File file = createFile(userinfo);
			StringBuffer sb = new StringBuffer();
			sb.append("用户亲属信息：");
			sb.append("\r\n");
			sb.append("姓名：" + userinfo.getUsername());
			sb.append("\r\n");
			sb.append("家庭关系：" + userinfo.getRelationship());
			sb.append("\r\n");
			sb.append("身份证：" + userinfo.getIdno());
			sb.append("\r\n");
			sb.append("手机：" + userinfo.getPhone());
			sb.append("\r\n");
			sb.append("地址：" + userinfo.getAddress());
			sb.append("\r\n");
			sb.append("工作：" + userinfo.getJob());
			sb.append("\r\n");
			sb.append("邮箱：" + userinfo.getMail());
			sb.append("\r\n");
			out = new OutputStreamWriter(new FileOutputStream(file),SystemConStants.ENCODING);
			out.write(sb.toString());
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		after();
		print();
       
        return SUCCESS;
	}
	
	/**
	 * 创建用户文件
	 * @return
	 * @author
	 * @throws IOException 
	 */
	private File createFile(Userinfo userinfo) throws IOException {

		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String date = dateFormat.format(now);

		String path = userinfo.getUsername()+"_"+userinfo.getIdno();

		File localDir = new File(SystemConStants.LOCAL_UPLOAD_DIR+File.separator+path+File.separator);
		if(!localDir.exists()) {
			localDir.mkdirs();
		}
		String filename = date+SystemConStants.FILE_TXT;

		File file = new File(SystemConStants.LOCAL_UPLOAD_DIR+File.separator+path+File.separator+filename);
		file.createNewFile();
		return file;	
	}
	
	public String delete(String name, String idno) {
        before();
		
		try{
			String path = name+"_"+idno;
	        
	        File localDir = new File(SystemConStants.LOCAL_UPLOAD_DIR+File.separator+path+File.separator);
			if (localDir.exists() && localDir.isDirectory()) {
				delete(localDir);  
			}
			
			if(!localDir.exists()) {
				this.retmsg = "success";
			}
			else {
				this.retmsg = "fail";	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		after();
		print();
       
        return SUCCESS;		
	}
	
	private static void delete(File file) {
        File[] childFiles = file.listFiles();  
        if (childFiles == null || childFiles.length == 0) {  
            file.delete();  
            return;  
        }  

        for (int i = 0; i < childFiles.length; i++) {  
            delete(childFiles[i]);  
        }  
        file.delete();
    } 
	
	@Override
    public String getRetmsg() {
        return retmsg;
    }

    @Override
    public String getRetcode() {
        return retcode;
    }

}
