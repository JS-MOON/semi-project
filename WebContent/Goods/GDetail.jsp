<%--
  Created by IntelliJ IDEA.
  User: JS
  Date: 2014-11-28
  Time: 오후 6:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 	request.setCharacterEncoding("UTF-8");
 	String cp = request.getContextPath();
%>
<html>
<head>
<title></title>

</head>
<body>

<script type="text/javascript">
	function comment() {

		var f = document.myForm;
		
		f.action = "comments_ok.do";
		f.submit();
	}
	
	
	function opplus(){
		
		var f = document.myForm2;
		alert(f.price.value + " : " + f.op.value + " : " + f.pr.value);
		return; 
		
		
	}
	
</script>





	<script language="JavaScript">
		function order() {
			var list = [ 'option1', 'option2', 'option3', 'option4', 'option5' ];
			var options = [];
			var option = "";

			for (var i = 0; i < list.length; i++) {
				if ($('input[id=' + list[i] + ']').is(":checked")) {
					options[i] = "on";
				} else {
					options[i] = "off";
				}
				option += options[i] + "$";
			}

			document.optionForm.complitedOption.value = option;

			document.optionForm.submit();
		}
	</script>

	<div id="container">

		<form method="post" action="../Goods/GOrder.do" name="optionForm">
			<input type="hidden" name="complitedOption" value="" />
		</form>

		<!-- contents -->
		<div id="contents" class="productView">

			<!-- location -->
			<div id="location">
				<span>홈</span> &gt; <span>재능마켓</span> &gt; <span>그래픽 디자인</span> &gt;
				<span>블로그/카페/웹</span>
			</div>
			<!-- //location -->

			<style type="text/css">
.auto-style2 {
	height: 31px;
}
</style>

			<div id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_UpdatePanel2">
				<form action="" method="post" name="myForm2">
				<!-- 제품정보 -->
				<div class="pdtInfo">
					<!-- 제품개요 -->
					<div class="pdtSummaryWrap">
						<div class="pdtThumb">
							<img id="" src="${imagePath }/${dto.brMainPhoto}"
								style="height: 452px; width: 452px;" />
						</div>
						<div class="pdtSummary">

							<img
								src="../resources/images/mypage/img_profile_img_blank_60x60.png"
								alt="" Height=51px Width=52px />
							<ul>
								<li><span class="summaryT">평균 응답시간</span> <span
									class="value"><span class="count"> <span
											id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_Label9"></span></span>분</span>
								</li>
								<li><span class="summaryT">현재 작업현황</span> <span
									class="value"><span class="count">0<span
											class="among">/<span
												id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_lbl_WorkCount">3</span></span></span>개</span>
								</li>
								<li><span class="summaryT">재능 작업일</span> <span
									class="value"><span class="count"> <span
											id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_lbl_WorkDays">2</span></span>일</span>
								</li>
								<li><span class="summaryT">평균 작업일</span> <span
									class="value"><span class="count"> <span
											id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_lbl_days">3</span></span>일</span>
								</li>
							</ul>
						</div>
					</div>
					<!-- 제품개요 -->

					<!-- 제품상세 -->
					<div class="pdtResumeWrap">
						<div class="pdtMark">
							<ul>
								<li><span class="mark markType1">미스터스 인증</span></li>
								<li><span
									id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_quickPost"
									class="mark markType2" style="display: none;">총알 전달 가능</span></li>
							</ul>
							<span class="sellerOnline"> <span>ONLINE</span>
							</span>
						</div>
						<p class="pdtCategory">
							<span>${category1 }</span>- <span>${category2 }</span>
						</p>
						<div>
							<h2 class="pdtTitle">${dto.brSubject }</h2>
						</div>
						<h3 class="pdtPrice">재능가</h3>
						<div class="priceRating">
							<span class="price"> <span class="num"> <span
									id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_lbl_price">${dto.brPrice }</span>
							</span> <img class="won"
								src="../resources/images/product/txt_won_detail.png" />
							</span> <span class="purchase"> <span class="count"> <span
									id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_lbl_buyCount">0</span>
							</span>명 구매 <span class="ratingAvg"> <img
									src="../resources/images/product/ico_rating_star.gif" alt="" />
									<img src="../resources/images/product/ico_rating_star.gif"
									alt="" /> <img
									src="../resources/images/product/ico_rating_star.gif" alt="" />
									<img src="../resources/images/product/ico_rating_star.gif"
									alt="" /> <img
									src="../resources/images/product/ico_rating_star.gif" alt="" />
							</span>
							</span>
						</div>
						<div id="" style="display:;">
							<div class="pdtOption">
								<h3>옵션선택</h3>

						
						
								<ol>
									<c:forEach var="i" begin="0" end="9" step="2">
										<li><span class="input-check"> <input
												type="checkbox" id="option1" onclick="opplus();"/>
										</span> <span class="label">${op[i] }</span> <span
											class="optionPrice">${op[i+1] }</span></li>
											<input type="hidden" name="op" value="${op[i] }">
											<input type="hidden" name="pr" value="${op[i+1] }">
									</c:forEach>
								</ol>
						<input type="hidden" name="price" value="${dto.brPrice }">
						

							</div>
						</div>
						<div class="amount">
							총 금액&nbsp; <span class="price"> ${dto.brPrice }<span>
							</span>
							</span> 원
						</div>
						<div class="btnArea al_r">
							<a id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_ibtn_req1"
								class="btnType2"
								href="javascript:__doPostBack(&#39;ctl00$ContentPlaceHolder1$WUC_Guest_AbilityDetail$ibtn_req1&#39;,&#39;&#39;)"><span>문의하기</span></a>
							<a id="" class="btnType3" href="javascript:order()"><span>구매하기</span></a>
						</div>
					</div>
					<!-- 제품상세 -->
				</div>
				<!-- //제품정보 -->
				</form>
				<!-- 제품상세정보 -->
				<div class="pdt-block">
					<div class="pdtDetailWrap">
						<div class="pdtDetail" style="text-align: center"></div>
						<div class="pdtDetail" style="text-align: center">
							<img id="" class="pdtDetail"
								src="${imagePath }/${dto.brMorePhoto}" /> <img
								src="../resources/images/product/txt_msg_product.png" /><br />
							<img src="../resources/images/product/btn_msg_product.png" />
						</div>

						
							<div class="pdtReview">
								<div id="pdtReviewBlock" class="tabMenu">
									<h4 id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_tabBtn1"
										class="tabBtn btn1 on">
										<a href="#photoReview"
											onclick="tabMenu(this , 'pdtReviewBlock'); return false;">포토후기</a>
									</h4>
									<div id="photoReview" class="tabContents photoReview">
										<table cellpadding="0" cellspacing="0" class="tblType1">
											<colgroup>
												<col />
												<col width="100" />
												<col width="335" />
												<col width="110" />
												<col width="105" />
											</colgroup>
											<thead>
												<tr>
													<th scope="col">
														<div class="th">평가</div>
													</th>
													<th scope="col">
														<div class="th">사진</div>
													</th>
													<th scope="col">
														<div class="th">내용</div>
													</th>
													<th scope="col">
														<div class="th">작성자</div>
													</th>
													<th scope="col">
														<div class="th">작성일</div>
													</th>
												</tr>
											</thead>
											<tr>
												<td colspan="5" class="seeMore">
													<div class="td">
														<a href="javascript:goNext();">더보기</a>
													</div>
												</td>
											</tr>
										</table>
									</div>
									<h4 id="ContentPlaceHolder1_WUC_Guest_AbilityDetail_tabBtn2"
										class="tabBtn btn2">
										<a href="#talentReview"
											onclick="tabMenu(this , 'pdtReviewBlock'); return false;">재능후기</a>
									</h4>
									<div id="talentReview" class="tabContents talentReview">
										<table cellpadding="0" cellspacing="0" class="tblType1">
											<colgroup>
												<col width="85" />
												<col width="435" />
												<col width="110" />
												<col width="105" />
											</colgroup>
											<thead>
												<tr>
													<th scope="col">
														<div class="th">평가</div>
													</th>
													<th scope="col">
														<div class="th">내용</div>
													</th>
													<th scope="col">
														<div class="th">작성자</div>
													</th>
													<th scope="col">
														<div class="th">작성일</div>
													</th>
												</tr>
											</thead>
											<thead>
											<c:forEach var="dto" items="${lists}" varStatus="seq">
												<tr>
													<th scope="col">
														<div class="th">
															<c:if test="${dto.cmRating==1}">
																★
															</c:if>
															<c:if test="${dto.cmRating==2}">
																★★
															</c:if>
															<c:if test="${dto.cmRating==3}">
																★★★
															</c:if>
															<c:if test="${dto.cmRating==4}">
																★★★★
															</c:if>
															<c:if test="${dto.cmRating==5}">
																★★★★★
															</c:if>
														</div>
													</th>
													<th scope="col">
														<div class="th">${dto.cmContent}</div>
													</th>
													<th scope="col">
														<div class="th">${dto.cmNickName}</div>
													</th>
													<th scope="col">
														<div class="th">${dto.cmDate}</div>
													</th>
												</tr>
												</c:forEach>
											</thead>
											
<!-- 
											<tr>
												<td colspan="4" class="seeMore">
													<div class="td">
														<a href="javascript:goNext2();">더보기</a>
													</div>
												</td>
											</tr> -->
											</table>
										<form action="comments_ok.do" method="post" name="myForm">		
										<table>
									
											<tr>
												<td><select name="cm_rating">
														<option value="1">★</option>
														<option value="2">★★</option>
														<option value="3">★★★</option>
														<option value="4">★★★★</option>
														<option value="5">★★★★★</option>
												</select>
												<td><input type="submit" value="등록" /></td>
											</tr>

											<tr>
												<td colspan="2"><textarea rows="3" cols="59"
														name="cm_content"></textarea></td>
												<td>닉네임<input type="text" name="cm_nickName"></td>
												<td><input type="hidden" name="brNum" value="${dto.brNum}"></td>
											</tr>

										</table>
										</form>
									</div>
								</div>
							</div>
						
					</div>

					<!-- 관련재능 -->
					<div class="pdtRelated">
						<h3 class="title">관련재능</h3>
						<ul>
							<li><a href="?&amp;cd=G00141027493130W&amp;ct=1101009">
									<span class="thumb"> <img
										src="../Product/M00141027728249W/Product/P141113123025.jpg"
										alt="7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. " Height=160px Width=160px />
								</span> <span class="name"> 7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. </span> <span
									class="price">10,000원</span>
							</a></li>
						</ul>
						<ul>
							<li><a href="?&amp;cd=G00141027493130W&amp;ct=1101009">
									<span class="thumb"> <img
										src="../Product/M00141027728249W/Product/P141113123025.jpg"
										alt="7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. " Height=160px Width=160px />
								</span> <span class="name"> 7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. </span> <span
									class="price">10,000원</span>
							</a></li>
						</ul>
						<ul>
							<li><a href="?&amp;cd=G00141027493130W&amp;ct=1101009">
									<span class="thumb"> <img
										src="../Product/M00141027728249W/Product/P141113123025.jpg"
										alt="7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. " Height=160px Width=160px />
								</span> <span class="name"> 7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. </span> <span
									class="price">10,000원</span>
							</a></li>
						</ul>
						<ul>
							<li><a href="?&amp;cd=G00141027493130W&amp;ct=1101009">
									<span class="thumb"> <img
										src="../Product/M00141027728249W/Product/P141113123025.jpg"
										alt="7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. " Height=160px Width=160px />
								</span> <span class="name"> 7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. </span> <span
									class="price">10,000원</span>
							</a></li>
						</ul>
						<ul>
							<li><a href="?&amp;cd=G00141027493130W&amp;ct=1101009">
									<span class="thumb"> <img
										src="../Product/M00141027728249W/Product/P141113123025.jpg"
										alt="7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. " Height=160px Width=160px />
								</span> <span class="name"> 7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. </span> <span
									class="price">10,000원</span>
							</a></li>
						</ul>
						<ul>
							<li><a href="?&amp;cd=G00141027493130W&amp;ct=1101009">
									<span class="thumb"> <img
										src="../Product/M00141027728249W/Product/P141113123025.jpg"
										alt="7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. " Height=160px Width=160px />
								</span> <span class="name"> 7일간 유지되는 당신만의 타투디자인을 만들어 드립니다. </span> <span
									class="price">10,000원</span>
							</a></li>
						</ul>
					</div>
					<!-- //관련재능 -->

				</div>
				<!-- //제품상세정보 -->
			</div>

			<!-- quick link -->
			<div id="quickLinks">

				<!-- 사이드 퀵마이페이지 -->
				<div class="quick-mypage quick-mypage-re">
					<ul class="menuList">
						<li class="wishPdt"><a class="wishPdt" href=""><span>찜한재능</span></a>
						</li>
						<li class="recentPdt"><span class="t"><span>최근본재능</span></span>
							<ul>
								<li><a
									href="../Goods/GDetail.jsp?&cd=G00141027915739W&ct=1301004">
										<img
										src="../Product/M00141027494883W/Product/P141113123054.jpg"
										alt="혹시 취업하고 싶니? 자소서..." Height=78px Width=78px />
								</a></li>
								<li><a
									href="../Goods/GDetail.jsp?&cd=G00141114429841W&ct=1801007">
										<img
										src="../Product/M00141114120734W/Product/P141119123948.jpg"
										alt="중고차 거래 도와드립니다." Height=78px Width=78px />
								</a></li>
								<li><a
									href="../Goods/GDetail.jsp?&cd=G00141121760220W&ct=1801011">
										<img
										src="../Product/M00141106553600W/Product/P141121102007.jpg"
										alt="이 멘트 하나면 열 썸녀!!..." Height=78px Width=78px />
								</a></li>
								<li><a
									href="../Goods/GDetail.jsp?&cd=G00141111234780W&ct=1801011">
										<img
										src="../Product/M00141023346855W/Product/P141113125134.jpg"
										alt="[연애경력5년차] 연애상담,..." Height=78px Width=78px />
								</a></li>
								<li><a
									href="../Goods/GDetail.jsp?&cd=G00141116522190W&ct=1101002">
										<img
										src="../Product/M00141114627107W/Product/P141124170623.jpg"
										alt="동글동글 귀여운 캘리그라피 ..." Height=78px Width=78px />
								</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- //사이드 퀵마이페이지 -->

			</div>
			<!--//quick link-->

		</div>
		<!-- //contents -->

	</div>

</body>
</html>
