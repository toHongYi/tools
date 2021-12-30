//package com.hongYi.pdf;
//
//import org.apache.pdfbox.exceptions.COSVisitorException;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//
//import java.io.IOException;
//
///**
// * @version : V1.0
// * @date : 2021/12/23 15:53
// * @Author : LLH
// * @Desc :
// */
//public class PDUtil02 {
//
//
//    public static void main(String[] args) {
//
//
//
//
//
//    }
//    /***
//     * 创建1到多个空白页面
//     * @param file
//     * @throws IOException
//     * @throws COSVisitorException
//     */
//    public static void createBlank(String s11)throws IOException, COSVisitorException {
//
//        //首先创建pdf文档类
//        PDDocument document = null;
//        try
//        {
//            document = new PDDocument();
//            //实例化pdf页对象
//            PDPage blankPage = new PDPage();
//            PDPage blankPage1 = new PDPage();
//            PDPage blankPage2 = new PDPage();
//            //插入文档类
//            document.addPage( blankPage );
//            document.addPage( blankPage1 );
//            document.addPage( blankPage2 );
//            //记得一定要写保存路径,如"H:\\text.pdf"
//            document.save( outputFile );
//            System.out.println("over");
//        }
//        finally
//        {
//            if( document != null )
//            {
//                document.close();
//            }
//        }
//    }
//
//    /**
//     * 读取pdf中文字信息(全部)
//     */
//    public static void READPDF(String inputFile){
//        //创建文档对象
//        PDDocument doc =null;
//        String content="";
//        try {
//            //加载一个pdf对象
//            doc =PDDocument.load(new File(inputFile));
//            //获取一个PDFTextStripper文本剥离对象
//            PDFTextStripper textStripper =new PDFTextStripper("GBK");
//            content=textStripper.getText(doc);
//            vo.setContent(content);
//            System.out.println("内容:"+content);
//            System.out.println("全部页数"+doc.getNumberOfPages());
//            //关闭文档
//            doc.close();
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//    }
//
//
//}
