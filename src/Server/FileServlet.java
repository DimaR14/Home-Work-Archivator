package Server;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
@WebServlet({"/file.zip"})
public class FileServlet  extends HttpServlet {
    private static final ArrayList<File> files = new ArrayList(5);
    private  File file1 = new File("file1.txt");
    private  File file2 = new File("file2.txt");
    private  File file3 = new File("file3.txt");
    private  File file4 = new File("file4.txt");
    private  File file5 = new File("file5.txt");


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] str = new String[6];
        for(int x = 1;x<=5;x++) {
            str[x] = req.getParameter("file" + x);
            if (str[x] != null && str[x].equals(file1.getName())) {
                files.add(file1);
            }if (str[x] != null && str[x].equals(file2.getName())) {
                files.add(file2);
            }if (str[x] != null && str[x].equals(file3.getName())) {
                files.add(file3);
            }if (str[x] != null && str[x].equals(file4.getName())) {
                files.add(file4);
            }if (str[x] != null && str[x].equals(file5.getName())) {
                files.add(file5);
            }
        }

       try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("D:\\java\\Home Work Archivator\\archive.zip"))) {
        for(File file:files){
            FileInputStream fis = new FileInputStream("D:\\java\\Home Work Archivator\\"+file.getName());
            ZipEntry ze = new ZipEntry("D:\\java\\Home Work Archivator\\"+file.getName());
            zip.putNextEntry(ze);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zip.write(buffer);
           }zip.closeEntry();
       }catch(Exception ex){
           System.out.println(ex.getMessage());
       }
        resp.setContentType("archive/zip");
        File archive = new File("D:\\java\\Home Work Archivator\\archive.zip");
        OutputStream os = resp.getOutputStream();
        FileInputStream fis = new FileInputStream("D:\\java\\Home Work Archivator\\archive.zip");
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        os.write(buffer);
        os.close();
        fis.close();
        archive.delete();
    }
}

