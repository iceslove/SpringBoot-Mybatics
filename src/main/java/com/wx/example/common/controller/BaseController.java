package com.wx.example.common.controller;

import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.dto.PageResult;
import com.wx.example.common.entity.PageBean;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public class BaseController {
    public PageResult showPageResult(PageBean<?> pageInfo){

        PageResult result = new PageResult();

        int page = pageInfo.getPageNum();
        int recordsTotal    = (int) pageInfo.getTotalCount() ;
        int recordsFiltered = (int) pageInfo.getTotalCount() ;
        List<?> items = pageInfo.getList() ;

        result.setPage(page);//第几页
        result.setRecordsTotal(recordsTotal);//总记录数
        result.setRecordsFiltered(recordsFiltered);//总记录数
        result.setItems(items);//数据

        return result;
    }

    public JsonResult showJsonResult(boolean code, String msg, Object data){
        JsonResult result = new JsonResult();
        if(code){
            result.setCode(JsonResult.SUCCESS);
        }else{
            result.setCode(JsonResult.ERROR);
        }
        result.setMsg(msg);
        result.setData(data);

        return result;
    }


    public Map<String,Object> buildSearchParam(HttpServletRequest request){

        //获取客户端需要那一列排序
        String orderColumn = request.getParameter("order[0][column]");
        orderColumn = request.getParameter("columns["+orderColumn+"][name]");
        //获取排序方式 默认为asc
        String orderDir  = request.getParameter("order[0][dir]");
        //获取查询关键字
        String keyword   = request.getParameter("keyword");

        Integer pageNum  = getPageNum(request);
        Integer pageSize = getPageSize(request);

        Map<String, Object> map = new HashMap<>();

        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("keyword",keyword);
        if(StringUtils.isNotBlank(orderColumn)){
            map.put("orderBy",orderColumn + " " + orderDir);
        }

        return map;
    }

    /**
     * 获得pager.offset参数的值
     *
     * @param request
     * @return
     */
    protected int getPageNum(HttpServletRequest request) {
        int pageNum = 1;
        try {
            String starts = request.getParameter("start");

            if (starts != null ) {
                int start  = Integer.parseInt(starts) + 1;
                int length = getPageSize(request);
                if(start % length == 0){
                    pageNum = start / length ;
                }else{
                    pageNum = start / length + 1 ;
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return pageNum;
    }

    /**
     * 设置默认每页大小
     *
     * @return
     */
    protected int getPageSize(HttpServletRequest request) {
        int pageSize = 10;    // 默认每页10条记录
        try {
            String pageSizes = request.getParameter("length");
            if (pageSizes != null ) {
                pageSize = Integer.parseInt(pageSizes);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return pageSize;
    }
}
