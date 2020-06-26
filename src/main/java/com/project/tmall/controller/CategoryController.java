package com.project.tmall.controller;

import com.project.tmall.pojo.Category;
import com.project.tmall.service.CategoryService;
import com.project.tmall.util.ImageUtil;
import com.project.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired CategoryService categoryService;

    @GetMapping("/categories")
    //size表示每一页显示的数据数量，navigatePages表示分页导航栏最多显示的个数
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0")
     int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0 ? 0 : start;
        Page4Navigator<Category> page = categoryService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    //添加新的类别信息
    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        //bean为前端传输过来到新的类别信息，下面这一步将分类信息保存到数据库中
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        //下一步将浏览器上传的文件复制到file文件路径上
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    //删除类别信息
    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request)throws Exception{
        categoryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return null;
    }

    //提供 get 方法，把id对应的Category取出来，并转换为json对象发给浏览器
    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id)throws Exception{
        Category bean = categoryService.get(id);
        return bean;
    }

    //修改需要使用REST规范的PUT
    @PutMapping("/categories/{id}")
    public Object update(Category bean,MultipartFile image,HttpServletRequest request)throws Exception{
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);

        if(image!=null){
            saveOrUpdateImageFile(bean,image,request);
        }
        return bean;
    }

}
