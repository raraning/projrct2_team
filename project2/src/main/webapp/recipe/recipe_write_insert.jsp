<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>

<%
request.setCharacterEncoding("utf-8");

//String uploadPath = request.getRealPath("/upload");
String uploadPath = "C:\\jsp\\project2\\src\\main\\webapp\\upload";
int size = 10*1024*1024; //10mb max

MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"utf-8",new DefaultFileRenamePolicy());

String file1 = "";
String file1_o = ""; //원본 파일명
String file1_s = ""; //썸네일 파일명

Enumeration files = multi.getFileNames();

file1=(String)files.nextElement();
file1_o=multi.getOriginalFileName("file1");
file1_s=multi.getFilesystemName("file1");

%>
