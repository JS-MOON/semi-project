<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<meta http-equiv="Page-Enter" content="BlendTrans(Duration=0.1)">
<meta http-equiv="Page-exit" content="BlendTrans(Duration=0.1)">

<style type="text/css">
    .hidden {
        display: none;
    }
    .dealList table tbody tr td.process .td {padding:10px 10px 0 10px; text-align:center; font-weight:bold; font-size:11px;}
    .dealList table tbody tr td.process.step9 .td { no-repeat 50% 0;}

</style>

<script>

    $(document).ready(function () {

        $('#NoData').addClass('hidden');
        $('#hasData').addClass('hidden');

        var cnt = '3'; //구매한 상품갯수

        if (cnt >= 1) {
            $('#NoData').addClass('hidden');
            $('#hasData').removeClass('hidden');
        } else {
            $('#NoData').removeClass('hidden');
            $('#hasData').addClass('hidden');
        }

    });
</script>

<!-- 마이페이지컨텐츠 시작 -->
<div class="primaryContents myPayment">
    <!-- 마이페이지lnb -->
    <div class="mypage_lnb">
        <h3>구매관리</h3>

        <div class="location">
            <span>홈</span> &gt; <span>마이페이지</span> &gt; <span>구매관리</span>
        </div>
    </div>
    <!-- //마이페이지lnb -->

    <!-- 내용 -->
    <div class="contBlock">
        <div id="NoData" class="nodata">
            <p class="nodata_msg">구매한 재능이 없습니다.</p>
        </div>



        <div id="hasData">


            <div class="sortArea">
                <br />
                <select name="ctl00$ContentPlaceHolder1$WUC_My_PurchaseList$ddl_searchField" onchange="javascript:setTimeout(&#39;__doPostBack(\&#39;ctl00$ContentPlaceHolder1$WUC_My_PurchaseList$ddl_searchField\&#39;,\&#39;\&#39;)&#39;, 0)" id="ContentPlaceHolder1_WUC_My_PurchaseList_ddl_searchField" class="select" style="width: 115px;">
                    <option selected="selected" value="1">주문일자</option>
                    <option value="2">주문상태</option>
                    <option value="3">완료일자</option>

                </select>


                <div class="listSearch">
                    <input name="ctl00$ContentPlaceHolder1$WUC_My_PurchaseList$txt_searchValue" type="text" id="ContentPlaceHolder1_WUC_My_PurchaseList_txt_searchValue" class="input-text" style="width: 210px;" />
                    <input type="image" name="ctl00$ContentPlaceHolder1$WUC_My_PurchaseList$ibtn_search" id="ContentPlaceHolder1_WUC_My_PurchaseList_ibtn_search" class="btnSearch" src="" />
                </div>
            </div>

            <!-- 게시판영역 -->
            <div class="dealList">

                <table cellpadding="0" cellspacing="0">
                    <colgroup>
                        <col width="70px" />
                        <col />
                        <col width="300px" />
                        <col width="100px" />
                        <col width="80px" />
                    </colgroup>

                    <thead>
                    <tr>
                        <th scope="col">
                            <div class="th">주문번호</div>
                        </th>
                        <th scope="col">
                            <div class="th">재능상품</div>
                        </th>
                        <th scope="col">
                            <div class="th">구매정보</div>
                        </th>
                        <th scope="col">
                            <div class="th">구매/마감일</div>
                        </th>
                        <th scope="col">
                            <div class="th">상태</div>
                        </th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr>
                        <td class="num">
                            <div class="td">
                                460527</div>
                        </td>
                        <td class="thumbnail">
                            <div class="td"><a href="../Goods/GDetail.aspx?st%3d1%26sv%3d&pg%3d1&cd=G00141024383368W&ct=1301001">
                                <img src="../Product/M00141024790168W/Product/P141113122246.jpg" alt="지루한 타이핑 작업 대신 해드리죠"   Height=160px  Width=160px  /></div>
                        </td>
                        <td class="payResume">
                            <div class="td">
                                지루한 타이핑 작업 대신 해드리죠
                                <dl class="option">
                                    <dt>옵션내역 : </dt>
                                    <dd>
                                    </dd>
                                </dl>
                                            <span class="price"><span class="count">
                                                5,000</span> 원</span>
                                <p class="dialogue mine">
                                </p>
                            </div>
                        </td>
                        <td class="date">
                            <div class="td">
                                            <span class="payDate">
                                                2014.12.01/</span>
                                            <span class="finishDate">
                                                </span>
                                []




                            </div>
                        </td>
                        <td onclick="location.href='/Chat/SChat.aspx?ccd=Mf00T2RIlJ7OvWuOTPk7De1Awb5gx5Pr64FJrPfPN3aQKE98vs2V2QMUdzZ4dvpj&ocd=VsnoRy5RJiDdXemxeYZs8wKdT79qwsTe40eLfklN/e8zPf15kmRFore4MU^62M6^';" style="cursor: pointer;" align="center" class="process step9" >
                            <img id="ContentPlaceHolder1_WUC_My_PurchaseList_rptList_Image2_0" src="../resources/images/mypage/BG_sellingProcess_ongoing.gif" /><div class="td">
                            진행중</div>
                        </td>
                        <!-- step1 ~ step4 -->

                    </tr>
                    </tbody>

                    <tbody>
                    <tr>
                        <td class="num">
                            <div class="td">
                                688110</div>
                        </td>
                        <td class="thumbnail">
                            <div class="td"><a href="../Goods/GDetail.aspx?st%3d1%26sv%3d&pg%3d1&cd=G00141024383368W&ct=1301001">
                                <img src="../Product/M00141024790168W/Product/P141113122246.jpg" alt="지루한 타이핑 작업 대신 해드리죠"   Height=160px  Width=160px  /></div>
                        </td>
                        <td class="payResume">
                            <div class="td">
                                지루한 타이핑 작업 대신 해드리죠
                                <dl class="option">
                                    <dt>옵션내역 : </dt>
                                    <dd>
                                    </dd>
                                </dl>
                                            <span class="price"><span class="count">
                                                5,000</span> 원</span>
                                <p class="dialogue mine">
                                </p>
                            </div>
                        </td>
                        <td class="date">
                            <div class="td">
                                            <span class="payDate">
                                                2014.12.01/</span>
                                            <span class="finishDate">
                                                </span>
                                []




                            </div>
                        </td>
                        <td onclick="location.href='/Chat/SChat.aspx?ccd=Mf00T2RIlJ7OvWuOTPk7De1Awb5gx5Pr64FJrPfPN3aQKE98vs2V2QMUdzZ4dvpj&ocd=VsnoRy5RJiDdXemxeYZs84Ogcjci74Sq4kA5PHiV0Edje3xd/rgALLiGHVVo8aBv';" style="cursor: pointer;" align="center" class="process step9" >
                            <img id="ContentPlaceHolder1_WUC_My_PurchaseList_rptList_Image2_1" src="../resources/images/mypage/BG_sellingProcess_ongoing.gif" /><div class="td">
                            진행중</div>
                        </td>
                        <!-- step1 ~ step4 -->

                    </tr>
                    </tbody>

                    <tbody>
                    <tr>
                        <td class="num">
                            <div class="td">
                                835311</div>
                        </td>
                        <td class="thumbnail">
                            <div class="td"><a href="../Goods/GDetail.aspx?st%3d1%26sv%3d&pg%3d1&cd=G00141024383368W&ct=1301001">
                                <img src="../Product/M00141024790168W/Product/P141113122246.jpg" alt="지루한 타이핑 작업 대신 해드리죠"   Height=160px  Width=160px  /></div>
                        </td>
                        <td class="payResume">
                            <div class="td">
                                지루한 타이핑 작업 대신 해드리죠
                                <dl class="option">
                                    <dt>옵션내역 : </dt>
                                    <dd>
                                    </dd>
                                </dl>
                                            <span class="price"><span class="count">
                                                5,000</span> 원</span>
                                <p class="dialogue mine">
                                </p>
                            </div>
                        </td>
                        <td class="date">
                            <div class="td">
                                            <span class="payDate">
                                                2014.12.01/</span>
                                            <span class="finishDate">
                                                </span>
                                []




                            </div>
                        </td>
                        <td onclick="location.href='/Chat/SChat.aspx?ccd=Mf00T2RIlJ7OvWuOTPk7De1Awb5gx5Pr64FJrPfPN3aQKE98vs2V2QMUdzZ4dvpj&ocd=VsnoRy5RJiDdXemxeYZs8wvyIWG17yLiueR5uHH3G7koHpivbmwfER6daIkRY36S';" style="cursor: pointer;" align="center" class="process step9" >
                            <img id="ContentPlaceHolder1_WUC_My_PurchaseList_rptList_Image2_2" src="../resources/images/mypage/BG_sellingProcess_ongoing.gif" /><div class="td">
                            진행중</div>
                        </td>
                        <!-- step1 ~ step4 -->

                    </tr>
                    </tbody>


                </table>
                <div class="tblLine2"></div>

                <div class="paging">

                    <b>1 </b>

                </div>
            </div>
            <!-- //게시판영역 -->

        </div>
    </div>
    <!-- //내용 -->
</div>
<!-- //마이페이지컨텐츠 시작 -->


</body>
</html>