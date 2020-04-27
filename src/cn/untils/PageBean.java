package cn.untils;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
    //service层（Some some,Int p）
    //1.查询总共有多少条记录 : count 可不写

    //2.设置每页显示多少条记录：pageSize 可不写

    //3.设置count / 设置pageTotal

    //4.设置当前第几页 ： p

    //5.分页查询数据：data

    //6.设置data


    private Integer count;//查询出来总共多少条记录
    private Integer p;//当前是第几页
    private Integer pageSize;//每页显示多少条记录
    private Integer pageTotal;//总共有多少页
    private List data;

    public PageBean() {
        pageSize = 2;
        data = new ArrayList();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        if (count == 0) {
            pageTotal = 1;
        } else if (count % pageSize == 0) {
            pageTotal = count / pageSize;
        } else {
            pageTotal = count / pageSize + 1;
        }
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        if (p < 1) {
            p = 1;
        }
        if (p > pageTotal) {
            p = pageTotal;
        }
        this.p = p;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {

        this.pageTotal = pageTotal;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}

    