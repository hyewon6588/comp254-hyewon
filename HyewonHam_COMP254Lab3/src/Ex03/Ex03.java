package Ex03;

import java.io.File;

public class Ex03 {
    public static String find(File path,String fileName){
        String realPath="";
        // Check if the path exists and is a directory
        if(!path.exists() ||!path.isDirectory()){
            System.out.println("Invalid directory: "+path);
        }

        //get file lists in current directory
        File[] files=path.listFiles();
        if (files == null) {
            System.out.println("Unable to list files in directory: " + path);
        }

        // Iterate over each file/directory
        for (File file : files) {
            if (file.isDirectory()) {
                // If it's a directory, recursively search inside
                realPath+=find(file, fileName);
            } else if (file.getName().equals(fileName)) {
                // If it's a file that user is looking for, retrieve parent directory
                realPath+=file.getParent()+"\\"+fileName;
            }
        }
        return realPath;
    }

    public static void main(String[] args) {
        String fileName="Lab Assignment 3_F20.docx";
        File path=new File("C:\\Users\\hyewo\\OneDrive\\바탕 화면\\centennialcollege\\docs\\SEMESTER4");
        System.out.println("Finding file name "+fileName);
        String realPath=find(path,fileName);
        if(realPath.isEmpty()){
            System.out.println("File not found");
        }else{
            System.out.println("File Found: "+realPath);
        }
    }
}
