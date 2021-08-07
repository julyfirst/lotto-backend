package com.lotto.dabak.vo;

import com.lotto.dabak.dto.request.paging.ReqCommonPaging;
import com.lotto.dabak.dto.response.paging.ResPaging;
import lombok.Data;

import java.util.List;

/**
 * page VO
 * @param <T>
 */
@Data
public class PageVO<T> {

    // 리스트
    private List<T> list;
    // 페이징 정보
    private ResPaging paging;

    public PageVO(List<T> list, long total, ReqCommonPaging paging) {
        this.list = list;
        this.paging = new ResPaging(
                paging.getIndex(),
                paging.getListCount(),
                paging.getPageCount(),
                total
        );
    }

}
