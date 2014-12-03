<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<style type="text/css">
    .hidden {
        display: none;
    }
</style>

<script type="text/javascript">
    function saveValidate() {
        var ctlUP = document.getElementById('fu_attach');
        var ctlFile1 = ctlUP.files[0];
        if (ctlFile1 == null) {
            return true;
        } else {
            if (ctlFile1.size > 10240000) {
                alert('최대 업로드 가능용량은 10M입니다.');
                return false;
            }
        }
        return true;
    }
</script>

<div class="primaryContents registerTalent">
    <!-- 마이페이지lnb -->
    <div class="mypage_lnb">
        <h3>재능등록</h3>
        <div class="location">
            <span>홈</span> &gt; <span>마이페이지</span> &gt; <span>재능등록</span>
        </div>
    </div>
    <!-- //마이페이지lnb -->

    <!-- 내용 -->
    <div class="contBlock">
        <div id="ContentPlaceHolder1_WUC_My_AblityEdit1_UpdatePanel1">

            <h4>카테고리</h4>
            <div class="settingOption category">

                <select name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$ddl_main" onchange="javascript:setTimeout(&#39;__doPostBack(\&#39;ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$ddl_main\&#39;,\&#39;\&#39;)&#39;, 0)" id="ContentPlaceHolder1_WUC_My_AblityEdit1_ddl_main" class="select" style="width:180px;width: 180px;">
                    <option selected="selected" value="110">그래픽 디자인</option>
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


                <select name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$ddl_sub" onchange="javascript:setTimeout(&#39;__doPostBack(\&#39;ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$ddl_sub\&#39;,\&#39;\&#39;)&#39;, 0)" id="ContentPlaceHolder1_WUC_My_AblityEdit1_ddl_sub" class="select" style="width:250px;width: 250px;">
                    <option selected="selected" value="1101011">도면/3D</option>
                    <option value="1101001">로고/BI/CI디자인</option>
                    <option value="1101008">만화/웹툰</option>
                    <option value="1101012">명함</option>
                    <option value="1101005">배너/상세페이지</option>
                    <option value="1101007">블로그/카페/웹</option>
                    <option value="1101003">사진/포토샵</option>
                    <option value="1101009">일러스트/그림</option>
                    <option value="1101006">전단지/홍보물</option>
                    <option value="1101004">캐리커쳐/인물</option>
                    <option value="1101010">캐릭터/아이콘</option>
                    <option value="1101002">캘리그라피</option>
                    <option value="1101013">POP</option>
                    <option value="1101014">PPT/템플릿</option>

                </select>

            </div>

            <h4>관련재능의 가격</h4>
            <div class="settingOption price">
                <label for="">최고가</label>

                <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_maxPrice" type="text" value="101010000" readonly="readonly" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_maxPrice" class="input-text" style="width:110px;width: 110px;" />

                <label for="">최저가</label>

                <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_minPrice" type="text" value="1000" readonly="readonly" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_minPrice" class="input-text" style="width:110px;width: 110px;" />


                <label for="" class="">선호가</label>

                <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_bestPrice" type="text" value="100000" readonly="readonly" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_bestPrice" class="input-text" style="width:110px;width: 110px;" />

            </div>

            <h4>재능 타이틀</h4>
            <div class="settingOption title">

                <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_title" type="text" maxlength="100" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_title" class="textarea" style="width: 100%; height: 55px;" />

            </div>

            <h4>상세 주소</h4>
            <p class="settingDesc">정확한 주소가 아닌 경우 위치기반 검색에서 노출이 되지 않을 수 있습니다.</p>
            <div class="settingOption address">

                <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_addr" type="text" maxlength="100" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_addr" class="input-text" style="width:510px;width: 100%;" />
            </div>

            <h4>연락처</h4>
            <p class="settingDesc">미스터스 팀에서 판매자에게 연락할 수 있는 번호를 입력해주세요.</p>
            <div class="settingOption">

                <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_tel1" type="text" maxlength="3" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_tel1" class="input-text" style="width:89px;width: 60px;" />
                -<input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_tel2" type="text" maxlength="4" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_tel2" class="input-text" style="width: 60px;" />
                -<input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_tel3" type="text" maxlength="4" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_tel3" class="input-text" style="width: 60px;" />

            </div>

            <div class="optionWrap">
                <div class="innerWrap item1">
                    <h4>재능 가격</h4>
                    <div class="settingOption">

                        <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_price" type="text" maxlength="12" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_price" class="input-text" style="width:129px;width: 113px;" />
                        <label for="">,000 원</label>
                    </div>
                </div>

                <div class="innerWrap item2">
                    <h4>평균 작업일</h4>
                    <div class="settingOption">

                        <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_wdays" type="text" maxlength="3" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_wdays" class="input-text" style="width:43px;width: 50px;" />
                        <label for="">일</label>
                    </div>
                </div>

                <div class="innerWrap item3">
                    <h4>동시작업 개수</h4>
                    <div class="settingOption">

                        <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_concur" type="text" maxlength="3" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_concur" class="input-text" style="width:62px;width: 50px;" />
                        <label for="">개</label>
                    </div>
                </div>

                <div class="innerWrap item4">
                    <h4>상품 재능 배송비</h4>
                    <div class="settingOption">

                        <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_dprice" type="text" value="0" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_dprice" class="input-text" style="width:118px;width: 113px;" />
                        <label for="">,000 원</label>
                    </div>
                </div>
            </div>

            <h4>옵션 추가</h4>
            <p class="settingDesc">
                옵션은 최대 5개까지 추가 가능합니다.&nbsp;&nbsp;
                <a id="ContentPlaceHolder1_WUC_My_AblityEdit1_lbtn_optAdd" class="btnType6" href="javascript:__doPostBack(&#39;ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$lbtn_optAdd&#39;,&#39;&#39;)"><span>옵션추가</span></a>

            </p>

            <h4>재능설명</h4>
            <div class="settingOption">

                <textarea name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_remark" rows="2" cols="20" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_remark" class="textarea" style="height:71px;width:772px;width: 100%; height: 270px;">
                </textarea>
            </div>

            <h4>작업 요구사항</h4>
            <div class="settingOption">

                <textarea name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_work" rows="2" cols="20" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_work" class="textarea" style="height:57px;width:749px;width: 100%; height: 130px;">
                </textarea>
                <!--
                        === 디자인파일참고 ===
                        작업의 편의를 위해 구매자에게 필수로 요구할 사항을 적어주세요.
                        ex) 명함디자인
                        이름: 한글/			한자/				영어/
                        전화번호:			휴대폰번호:			팩스:
                        이메일:				주소: -->
            </div>



        </div>
        <h4>첨부파일</h4>
        <p class="settingDesc">포트폴리오 및 상세페이지에서 사용될 모든 자료를 하나로 압축해서 올려주세요.<font color="red"> (용량제한: 10MB 미만)</font></p>
        <div class="settingOption">

            <input type="file" name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$fu_attach" id="fu_attach" class="input-file" style="width:498px;width: 100%;" />
        </div>

        <h4>Youtube URL</h4>
        <p class="settingDesc">본인 재능을 소개하는 영상자료 TAG를 입력해주세요.</p>
        <div class="settingOption">

            <input name="ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$txt_ytube" type="text" maxlength="1000" id="ContentPlaceHolder1_WUC_My_AblityEdit1_txt_ytube" class="input-text" style="width: 100%;" />
        </div>

        <div class="note">
            <strong>등록전 확인해주세요</strong>
            <ul>
                <li>- 판매자는 재능 등록과 동시에 해당 재능을 판매할 의무가 있습니다.</li>
                <li>- 등록한 재능이 관련법규를 위반한 경우, 모든 책임은 판매자가 감수합니다.</li>
                <li>- 등록한 재능은 관리자의 승인절차를 거치며, 재능이 적합해야만 판매 하실수 있습니다.</li>
                <li>- 등록하신 재능은 디자인 편집을 거쳐 게시됩니다. 추가적인 이미지나 첨부자료를 요청받으실 수 있습니다.</li>
                <li>- 업무시간(월~금: 오전 9:00 ~ 오후 6:00) 이외에 재능을 등록 및 편집시 승인이 늦어질 수 있습니다.</li>
                <li>- 구매자와 직거래를 유도하는 경우 판매정지 및 미스터스 접속에 제한을 받을수 있으니 주의 바랍니다.</li>
                <li>- 임시저장한 재능은 구매자에게 노출되지 않으며, 관리자의 승인도 거치지 않습니다.</li>
                <li>- 임시저장한 재능은 추후 나의 재능에서 작성완료하신 후 다시 등록요청하셔야 합니다.</li>
            </ul>
        </div>

        <div class="btnArea al_c">

            <a id="ContentPlaceHolder1_WUC_My_AblityEdit1_ltn_tempsave" class="btnType2" href="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$ltn_tempsave&quot;, &quot;&quot;, true, &quot;work&quot;, &quot;&quot;, false, true))"><span>임시저장</span></a>
            <a onclick="javascript:return saveValidate();" id="ContentPlaceHolder1_WUC_My_AblityEdit1_ltn_save" class="btnType3" href="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$ContentPlaceHolder1$WUC_My_AblityEdit1$ltn_save&quot;, &quot;&quot;, true, &quot;work&quot;, &quot;&quot;, false, true))"><span>등록 요청</span></a>

        </div>
    </div>
    <!-- //내용 -->
</div>


</body>
</html>