package com.hongYi.pdf.model;

import java.util.Date;

/**
 * @version : V1.0
 * @date : 2021/12/23 16:03
 * @Author : LLH
 * @Desc :
 */
public class pdfDomainVO {
    //实体类的名称:pdfDomainVO

    private Integer id;//id

    private Date time;//操作时间

    private String filename;//文件名

    private String filesize;//文件大小

    private String filetype;//文件类型

    private String details;//操作详情

    private String content;//pdf中内容

    private String outputfile;//输出路径(保存路径)

    private String inputfile;//要操作的pdf路径

    private String strtofind;//需要替换的文本

    private String message;//替换的文本

    private String imagefile;//图片路径

    private String imagelist;//图片集合

    private Integer pageno;//指定页码

    private Integer pages;//总页数

    private Integer rid;//...

    private Integer pageoperation;//操作页数

    private Integer pagestart;//开始页

    private Integer pageend;//结束页

    private String position;//位置:X,Y

    private String fileSizeAfter;//操作后文件大小

    private Integer status;//状态

    private Integer afterPages;//操作后页码

    private Integer imgSize;//图片大小


}
