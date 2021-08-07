package com.lotto.dabak.dto.response.paging;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * REST API Response paging 처리
 *
 */
@Data
@NoArgsConstructor
public class ResPaging implements Serializable {

    @ApiModelProperty("페이지 번호")
    private long index = 1;

    @ApiModelProperty("리스트 갯수")
    private long listCount = 5;

    @ApiModelProperty("리스트 총 갯수")
    private long total = 1;

    @ApiModelProperty("페이지 번호 갯수")
    private long pageCount = 5;

    @ApiModelProperty("페이지 시작 번호")
    private long pageStartNum = 1;

    @ApiModelProperty("페이지 마지막 번호")
    private long pageLastNum = 1;

    @ApiModelProperty("next 버튼 생성여부")
    private boolean lastBtn;


    public ResPaging(long index, long listCount, long pageCount, long total) {
        this.index = index;
        this.listCount = listCount;
        this.pageCount = pageCount;
        this.setTotal(total);
    }

    public void setTotal(long total) {
        this.total = total;

        pageStartNum = index / pageCount * pageCount + 1;
        if (index % pageCount == 0) {
            pageStartNum -= pageCount;
        }

        if (listCount != 0) {
            long remainListCnt = total - listCount * (pageStartNum - 1);
            long remainPageCnt = remainListCnt / listCount;
            if (remainListCnt % listCount != 0) {
                remainPageCnt++;
            }
            if (remainListCnt <= listCount) {
                pageLastNum = pageStartNum;
            } else if (remainPageCnt <= pageCount) {
                pageLastNum = remainPageCnt + pageStartNum - 1;
            } else {
                pageLastNum = pageCount + pageStartNum - 1;
            }
            long n = (long) Math.ceil((double) total / listCount);
            lastBtn = pageLastNum != n && n != 0;
        }
    }
}
