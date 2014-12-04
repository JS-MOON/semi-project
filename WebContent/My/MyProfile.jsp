<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<script>
    function popUP(mypage, myname, winl, wint, w, h, scroll, titlebar, status, menubar, location) {
        winprops = 'height=' + h + ',width=' + w + ',top=' + wint + ',left=' + winl + ',toolbar=no,scrollbars=' + scroll + ',status=' + status + ',menubar=' + menubar + 'location=' + location + ',resize=no'
        //window.open(url,popname,"toolbar=no,width=350px;,height=285px;,directories=no,status=no,scrollbars=no,resize=no,menubar=no");//
        win = window.open(mypage, myname, winprops)
        if (parseInt(navigator.appVersion) >= 4) {
            win.window.focus();
        }
    }
</script>

<div class="primaryContents myProfile">
    <!-- 마이페이지lnb -->
    <div class="mypage_lnb">
        <h3>프로필 관리</h3>
        <div class="location">
            <span>홈</span> &gt; <span>마이페이지</span> &gt; <span>포인트 관리</span>
        </div>
    </div>
    <!-- //마이페이지lnb -->

    <!-- 내용 -->
    <div class="contBlock">
        <div class="sectionTop">
            <div class="profile_img">
                <span class="profile_thumb">
                    <img src="../resources/images/mypage/img_profile_img_blank_120x120.png" alt="" /></span>
                <a href="javascript:popUP('../Comm/PhotoUpload.jsp','UploadProfilePhoto',50,50,200,100,'no','no','no','no','no');" class="replace">Replace</a>
            </div>
            <ul class="i_r">
                <li>
                    <span class="dt">ID</span>
                    <input name="ctl00$ContentPlaceHolder1$WUC_MyProfile1$txtID" type="text" value="mjsung2@nate.com" maxlength="50" readonly="readonly" id="ContentPlaceHolder1_WUC_MyProfile1_txtID" class="input-text" style="width: 410px;" />
                </li>
                <li>
                    <span class="dt">개인 URL</span>
                    <input name="ctl00$ContentPlaceHolder1$WUC_MyProfile1$txtPUrl" type="text" maxlength="200" id="ContentPlaceHolder1_WUC_MyProfile1_txtPUrl" class="input-text" style="width: 410px;" />
                </li>
                <li>
                    <span class="dt">닉네임</span>
                    <input name="ctl00$ContentPlaceHolder1$WUC_MyProfile1$txtNickname" type="text" maxlength="20" id="ContentPlaceHolder1_WUC_MyProfile1_txtNickname" class="input-text" style="width: 410px;" />
                </li>
            </ul>
        </div>
        <dl class="i_r">
            <dt>소개</dt>
            <dd>
                <textarea name="ctl00$ContentPlaceHolder1$WUC_MyProfile1$txtInfo" rows="2" cols="20" id="ContentPlaceHolder1_WUC_MyProfile1_txtInfo" class="textarea" title="소개" placeholder="자신을 어필할 수 있는 공간입니다.
자격증이나 경력사항을 상세히 적어주시면 구매자분께 더 어필할 수 있습니다.
(단, 연락처를 기제하여 직거래를 유도하려고 하는 경우 제제를 당할 수 있습니다.)" style="height:206px;width:710px;width: 100%; height: 198px;">
                </textarea></dd>
        </dl>
        <dl class="i_r">
            <dt>관심분야</dt>
            <dd>
                <select name="ctl00$ContentPlaceHolder1$WUC_MyProfile1$ddl_BizLoc1" id="ContentPlaceHolder1_WUC_MyProfile1_ddl_BizLoc1" class="input-text" style="width: 175px;">
                    <option selected="selected" value="0">---관심분야선택---</option>
                    <option value="110">그래픽 디자인</option>
                    <option value="120">사업 전문가</option>
                    <option value="130">문서 레포트</option>
                    <option value="140">컴퓨터 IT</option>
                    <option value="150">번역 외국어</option>
                    <option value="160">음악 동영상</option>
                    <option value="170">행사 공연</option>
                    <option value="180">노하우 상담</option>
                    <option value="190">생활서비스</option>
                    <option value="200">여행 가이드</option>
                    <option value="210">핸드메이드</option>

                </select>
                <select name="ctl00$ContentPlaceHolder1$WUC_MyProfile1$ddl_BizLoc2" id="ContentPlaceHolder1_WUC_MyProfile1_ddl_BizLoc2" class="input-text" style="width: 175px; margin: 0 40px;">
                    <option selected="selected" value="0">---관심분야선택---</option>
                    <option value="110">그래픽 디자인</option>
                    <option value="120">사업 전문가</option>
                    <option value="130">문서 레포트</option>
                    <option value="140">컴퓨터 IT</option>
                    <option value="150">번역 외국어</option>
                    <option value="160">음악 동영상</option>
                    <option value="170">행사 공연</option>
                    <option value="180">노하우 상담</option>
                    <option value="190">생활서비스</option>
                    <option value="200">여행 가이드</option>
                    <option value="210">핸드메이드</option>

                </select>
                <select name="ctl00$ContentPlaceHolder1$WUC_MyProfile1$ddl_BizLoc3" id="ContentPlaceHolder1_WUC_MyProfile1_ddl_BizLoc3" class="input-text" style="width: 175px;">
                    <option selected="selected" value="0">---관심분야선택---</option>
                    <option value="110">그래픽 디자인</option>
                    <option value="120">사업 전문가</option>
                    <option value="130">문서 레포트</option>
                    <option value="140">컴퓨터 IT</option>
                    <option value="150">번역 외국어</option>
                    <option value="160">음악 동영상</option>
                    <option value="170">행사 공연</option>
                    <option value="180">노하우 상담</option>
                    <option value="190">생활서비스</option>
                    <option value="200">여행 가이드</option>
                    <option value="210">핸드메이드</option>

                </select>
            </dd>
        </dl>
        <div class="btnArea al_r">
            <a id="ContentPlaceHolder1_WUC_MyProfile1_lbtnSave" class="btnType12" href="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$ContentPlaceHolder1$WUC_MyProfile1$lbtnSave&quot;, &quot;&quot;, true, &quot;MyProfile&quot;, &quot;&quot;, false, true))"><span>저장</span></a>
        </div>
    </div>
    <!-- //내용 -->
</div>

</body>
</html>