<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<script src="../resources/js/Common.js"></script>
<script>
    // var authPop;

    function loadPayreq() {
        document.getElementById("ifMobileAuth").src = "/LgXpay/AuthOnlyReq.jsp?";
    }

    //function winOpen() {
    //    authPop = window.open("/LgXpay/AuthOnlyReq.jsp", "winAuth", "width=400 height=180 menubar=no status=no location=no");
    //}

    function fn_refresh() {

        //  authPop.close();
        window.location.href = "/My/MyAuth.jsp";

    }
</script>

<div class="primaryContents certificationManage">
    <!-- 마이페이지lnb -->
    <div class="mypage_lnb">
        <h3 class="tit1 on"><a href="../My/MyAuth.jsp">인증 관리</a></h3>
        <h3 class="tit2"><a href="../My/MyAccount.jsp">계정 관리</a></h3>
        <div class="location">
            <span>홈</span> &gt; <span>마이페이지</span> &gt; <span>인증/계정 관리</span>
        </div>
    </div>
    <!-- //마이페이지lnb -->

    <!-- 내용 -->
    <div class="contBlock">
        <div class="tblType">
            <table cellpadding="0" cellspacing="0">
                <colgroup>
                    <col width="100px" />
                    <col />
                </colgroup>
                <tbody>
                <tr>
                    <th scope="row">
                        <div class="th">이메일 인증</div>
                    </th>
                    <td>
                        <div id="ContentPlaceHolder1_WUC_MyAuth1_divAuthEmail" class="td">
                            <input name="ctl00$ContentPlaceHolder1$WUC_MyAuth1$txtEmail" type="text" value="mjsung2@nate.com" maxlength="50" readonly="readonly" id="ContentPlaceHolder1_WUC_MyAuth1_txtEmail" class="input-text" style="width: 100%;" />
                            <p class="helpMsg">이메일은 회원가입 단계에 인증합니다.</p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">
                        <div class="th">본인 인증</div>
                    </th>
                    <td>
                        <div id="ContentPlaceHolder1_WUC_MyAuth1_divAuthName" class="td">
                            <input name="ctl00$ContentPlaceHolder1$WUC_MyAuth1$txtName" type="text" maxlength="20" readonly="readonly" id="ContentPlaceHolder1_WUC_MyAuth1_txtName" class="input-text" style="width: 357px" />


                            <a href="#" class="btnType13" onclick="loadPayreq()">휴대폰</a><br>
                            <p class="helpMsg">판매자로 활동하시려면 본인인증이 필요합니다.</p>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th scope="row">
                        <div class="th">계좌 인증</div>
                    </th>
                    <td class="">
                        <div id="ContentPlaceHolder1_WUC_MyAuth1_divAuthBKAcount" class="td">
                            <select name="ctl00$ContentPlaceHolder1$WUC_MyAuth1$ddlBankNm" id="ContentPlaceHolder1_WUC_MyAuth1_ddlBankNm" class="select" style="width: 120px;">
                                <option value="1">국민은행</option>
                                <option value="2">우리은행</option>
                                <option value="3">신한은행</option>
                                <option value="4">하나은행</option>
                                <option value="5">SC은행</option>
                                <option value="6">새마을금고</option>
                                <option value="7">우체국</option>
                                <option value="8">씨티은행</option>
                                <option value="9">외환은행</option>
                                <option value="10">농협</option>
                                <option value="11">수협</option>
                                <option value="12">산업은행</option>
                                <option value="13">기업은행</option>
                                <option value="14">수출입은행</option>
                                <option value="15">직접입력</option>

                            </select>
                            <input name="ctl00$ContentPlaceHolder1$WUC_MyAuth1$txtBankOwner" type="text" maxlength="20" id="ContentPlaceHolder1_WUC_MyAuth1_txtBankOwner" class="input-text" title="예금주명" placeholder="예금주명" style="width: 288px;" />
                            <input name="ctl00$ContentPlaceHolder1$WUC_MyAuth1$txtBankAccount" type="text" maxlength="20" id="ContentPlaceHolder1_WUC_MyAuth1_txtBankAccount" class="input-text" title="계좌번호" placeholder="계좌번호" style="width: 100%; margin-top: 10px;" />
                            <p class="helpMsg">
                                재능을 판매하고 얻은 수익금을 출금하려면 계좌 인증을 하셔야 합니다.<br />
                                예금주가 본인과 일치하지 않을 경우, 출금이 제한될 수 있습니다.
                            </p>
                            <div class="btnArea">
                                <a id="ContentPlaceHolder1_WUC_MyAuth1_lbtnSaveBank" class="btnType12" href="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$ContentPlaceHolder1$WUC_MyAuth1$lbtnSaveBank&quot;, &quot;&quot;, true, &quot;MyBank&quot;, &quot;&quot;, false, true))"><span>저장</span></a>
                            </div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
    <!-- //내용 -->
</div>


</body>
</html>