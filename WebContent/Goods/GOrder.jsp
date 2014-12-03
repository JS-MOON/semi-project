<%--
  Created by IntelliJ IDEA.
  User: JS
  Date: 2014-12-01
  Time: 오후 2:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<div id="container">
    <!-- contents -->

    <script src="../resources/js/Common.js"></script>

    <div id="ContentPlaceHolder1_WUC_GOrder1_upPoint">

        <div id="contents">
            <!-- location -->

            <div id="location">
                <span>홈</span> &gt; <span>재능주문</span> &gt; <span>문서 레포트</span>  &gt; <span>문서 레포트</span>
            </div>
            <!-- //location -->

            <h2 class="paymentTitle">이 재능 결제하기</h2>
            <div class="payment">
                <!-- 결제대상 -->
                <div class="payTarget">
                    <div class="pdtThumb">
                        <img src="../Product/M00141024790168W/Product/P141113122246.jpg" width="180" height="180" alt="지루한 타이핑 작업 대신 해..." /><!--<img src="../resources/images/temp/img_185x155.gif" alt="" />-->
                    </div>
                    <div class="pdt_info">
                        <div class="pdtMark">
                            <ul>
                                <li><span class="mark markType1">미스터스 인증</span></li>
                                <li><span class="mark markType2">총알 전달 가능</span></li>
                            </ul>
                        </div>
                        <span class="category">
                            문서 레포트 - 문서 레포트</span>
                        <div class="pdtTitle">
                            <strong class="tit">
                                지루한 타이핑 작업 대신 해...</strong>
                            <div class="price">
                                <!--<span class="dt">재능가</span>-->
                                <span class="dd"><span class="num">
                                    5,000</span> 원</span>
                                <span class="period">기본 소요 기간 <span>
                                    1
                                    일</span></span>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- //결제대상 -->

                <h3 class="payment_h_tit">옵션사항</h3>
                <div class="paymentDetail detailOption">
                    <ol class="optionList">

                    </ol>
                    <dl class="total">
                        <dt>옵션 추가 금액</dt>
                        <dd><span class="num">+
                            0</span> 원</dd>
                        <dt>추가 소요 기간</dt>
                        <dd><span class="num">+
                            0</span> 일</dd>
                    </dl>
                </div>

                <h3 class="payment_h_tit">포인트 사용</h3>
                <div class="paymentDetail usePoint">
                    <ul>
                        <li>
                            <span class="aspNetDisabled input-radio"><input id="ContentPlaceHolder1_WUC_GOrder1_rUseYesPoint" type="radio" name="ctl00$ContentPlaceHolder1$WUC_GOrder1$UsePointMileage" value="rUseYesPoint" disabled="disabled" onclick="javascript:setTimeout(&#39;__doPostBack(\&#39;ctl00$ContentPlaceHolder1$WUC_GOrder1$rUseYesPoint\&#39;,\&#39;\&#39;)&#39;, 0)" /></span><label for="usePoint" class="label">포인트 <span>(현재:0
                                P)</span></label></li>
                        <li>
                            <span class="input-radio"><input id="ContentPlaceHolder1_WUC_GOrder1_rUseNoPoint" type="radio" name="ctl00$ContentPlaceHolder1$WUC_GOrder1$UsePointMileage" value="rUseNoPoint" checked="checked" /></span><label for="usePoint" class="label">사용안함 <span></span></label>
                        </li>
                    </ul>
                </div>

                <div class="paymentDetail orderSum">
                    <div class="orderSumDetail default">
                        <strong class="tit">재능 기본가</strong>
                        <span class="sum"><span class="num">
                            5,000</span> 원</span>
                    </div>
                    <span class="paymentOptions plus">더하기</span>
                    <div class="orderSumDetail option">
                        <strong class="tit">옵션가</strong>
                        <span class="sum"><span class="num">
                            0</span> 원</span>
                    </div>
                    <span class="paymentOptions minus">더하기</span>
                    <div class="orderSumDetail point">
                        <strong class="tit">포인트</strong>
                        <span class="sum"><span class="num">
                            0</span> 원</span>
                    </div>
                    <span class="paymentOptions equal">더하기</span>
                    <div class="orderSumDetail amount">
                        <strong class="tit">총 주문 금액</strong>
                        <span class="vat">(VAT 10% 별도)</span>
                        <span class="sum"><span class="num">
                            5,000</span> 원</span>
                    </div>
                </div>

                <h3 class="payment_h_tit">결제방식</h3>
                <div class="paymentDetail payMethod">
                    <ul>
                        <div id="ContentPlaceHolder1_WUC_GOrder1_divPointAll" style="display:none;">
                            <li>
                                <span class="input-radio"><input id="ContentPlaceHolder1_WUC_GOrder1_rPayTypePointAll" type="radio" name="" value="rPayTypePointAll" /></span><label class="label">포인트 전액</label></li>
                        </div>
                        <div id="ContentPlaceHolder1_WUC_GOrder1_divBankInput" style="display:;">
                            <li>
                                <span class="input-radio"><input id="ContentPlaceHolder1_WUC_GOrder1_rPayTypeBankInput" type="radio" name="" value="rPayTypeBankInput" /></span><label class="label">무통장 입금</label></li>
                        </div>
                    </ul>
                </div>

                <h3 class="payment_h_tit">주문 전 확인하세요</h3>
                <div class="paymentDetail note">
                    <ul>
                        <li>판매자의 설명과 옵션을 확인해주세요. 잘못된 주문은 판매자가 취소할 수 있습니다.</li>
                        <li>주문에 대한 결과물은 미스터스에서 책임지지 않습니다.</li>
                        <li>하지만 구매한 재능이 설명과 다르거나 판매자가 연락이 되지 않는 경우, 상호 동의하여 주문을 취소할 수 있습니다.</li>
                    </ul>
                </div>

                <div class="totalAmount">
                    <dl class="dl1">
                        <dt>총 결제 금액</dt>
                        <dd><span class="num">
                            5,500</span> 원</dd>
                    </dl>
                    <div class="vat">(VAT 10% 포함)</div>
                    <dl class="dl2">
                        <dt>완료 소요 기간</dt>
                        <dd><span class="num">
                            1</span> 일</dd>
                    </dl>
                </div>

                <div class="btnArea al_c">
                    <a class="btnType3" href=""><span>결제하기</span></a>
                </div>
            </div>
        </div>

    </div>

    <!-- //contents -->
</div>

</body>
</html>
