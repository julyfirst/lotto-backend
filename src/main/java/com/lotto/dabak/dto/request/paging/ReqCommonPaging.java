package com.lotto.dabak.dto.request.paging;

public interface ReqCommonPaging {
    int index();
    int offset();
    int limit();
    int getIndex();
    int getListCount();
    int getPageCount();
    void setIndex(int index);
    void setListCount(int listCount);
    void setPageCount(int pageCount);
}
