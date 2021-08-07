package com.lotto.dabak.dto.request.paging;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
/**
 * REST API Request paging
 *
 */
@Data
@NoArgsConstructor
public class ReqPaging implements ReqCommonPaging {

    @ApiModelProperty("페이지 번호")
    @Range(min = 1)
    private int index = 1;

    @ApiModelProperty("리스트 갯수")
    @Range(min = 1, max = 100)
    private int listCount = 5;

    @ApiModelProperty("페이지 번호 갯수")
    @Range(min = 1)
    private int pageCount = 5;


    public ReqPaging(int index, int listCount, int pageCount) {
        this.index = index;
        this.listCount = listCount;
        this.pageCount = pageCount;
        if (listCount > 100) {
            this.listCount = 100;
        }
    }

    public int index() {
        return index - 1;
    }

    public int offset() {
        return index() * listCount;
    }
    // rownum query 전용
    public int limit() {
        return (index() * listCount) + listCount;
    }






}
