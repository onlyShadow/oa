package com.clearnight.oa.filemanage.service;

import java.io.IOException;

import com.clearnight.oa.filemanage.bean.FileBean;
import com.clearnight.oa.login.bean.Account;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.web.multipart.MultipartFile;


public interface IFileManageService {
	
	/**
	 * 获得文件结构的表格JSON数据
	 * @param fileId 文件路径
	 * @return String
	 */
	public String getFileStructureDataGridJSONString(String fileId, Account account);
	
	/**
	 * 添加文件夹
	 * @param fileBean 文件夹对象
	 * @param parentId 父文件id
	 */
	public void saveFolder(FileBean fileBean, String parentId, String userId);
	
	/**
	 * 是否能添加文件夹
	 * @param fileName 文件夹名称
	 * @return boolean
	 */
	public boolean canAddFolder(String fileName, String id);
	
	/**
	 * 根据文件类型来获得代表文件的图片的字节码
	 * @param fileType 文件类型
	 * @return 代表该文件的图片字节码
	 */
	public byte[] getFileByteByFileTypeStr(String fileType)throws JSchException, SftpException, IOException;

	/**
	 * 删除文件
	 * @param id 文件ID
	 */
	public void deleteFileBean(String id)throws Exception;
	
	/**
	 * 根据id查询文件
	 * @param id 文件ID
	 * @return FileBean
	 */
	public FileBean getFileBeanById(String id);

	/**
	 * 上传文件
	 * @param name 文件名称
	 * @param file 文件对象
	 * @param parentId 上级ID
	 * @return FileBean
	 */
	public FileBean uploadFile(String name,MultipartFile file,String parentId,String userId);

	/**
	 * 根据文件ID获得文件字节数组
	 * @param fileId 文件ID
	 * @return byte[]
	 */
	public byte[] getFileBeanByteByFileId(String fileId) throws JSchException, SftpException, IOException;


}
