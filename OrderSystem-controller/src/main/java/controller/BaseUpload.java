package controller;

import com.zengjisheng.www.util.UploadUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 作为一个工具类,将数据封装成一个ArrayList,并将图片保存到指定的位置中
 */
@WebServlet("/BaseUpload")
public class BaseUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<String> fileList;
    private final String[] fileType = new String[]{".jpg", ".gif", ".bmp", ".png", ".jpeg", ".ico"};
    private String path = "";

    // 设置存储路径
    public void setPath(String path) {
        this.path = path;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断form 是否为上传form
        if (ServletFileUpload.isMultipartContent(request)) {
            // 步骤一 工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 步骤二 解析器
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            // 处理上传附件名乱码
            fileUpload.setHeaderEncoding("UTF-8");
            // 步骤三 解析请求
            try {
                List<FileItem> fileItems = fileUpload.parseRequest(request);
                fileList = new ArrayList<>();
                // 步骤四 遍历List集合获得每一个FileItem
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        fileList.add(fileItem.getString("UTF-8"));
                    }
                    // 步骤五 判断fileItem 是不是一个文件上传项
                    else {
                        // 文件上传项
                        String fileName = fileItem.getName();
                        // 1、不允许空文件，不上传
                        if (fileName == null || fileName.length() == 0) {
                            throw new RuntimeException("必须要上传文件！");
                        }
                        // 2、判断文件是否有路径，如果存在路径将路径切掉
                        fileName = UploadUtils.subFileName(fileName);
                        // 判断是否为图片
                        if (fileName.endsWith(fileType[0]) || fileName.endsWith(fileType[1])
                                || fileName.endsWith(fileType[2]) || fileName.endsWith(fileType[3])
                                || fileName.endsWith(fileType[4]) || fileName.endsWith(fileType[5])) {
                            // 3、生成唯一文件名 uuidName
                            String uuidName = UploadUtils.generateUUIDName(fileName);
                            fileList.add(uuidName);
                            // 4、根据hash算法生成分散目录
                            String randomdir = UploadUtils.generateRandomDir(uuidName);
                            fileList.add(randomdir);
                            // System.out.println(request.getSession().getServletContext().getRealPath("/FoodSystem/web/upload"));
                            // 创建随机目录
                            File dir = new File(path + randomdir);
                            dir.mkdirs();
                            String image_path = dir.getPath() + "\\" + uuidName;
                            request.getSession().setAttribute("image_path", image_path);
                            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(dir, uuidName)));
                            InputStream in = new BufferedInputStream(fileItem.getInputStream());
                            int temp;
                            while ((temp = in.read()) != -1) {
                                out.write(temp);
                            }
                            in.close();
                            out.close();

                            // 删除临时文件
                            fileItem.delete();
                        } else {
                            fileList = null;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("图片上传失败！请确认格式是否正确");
            }
        }
    }

    public List<String> getFileList() {
        return fileList;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
