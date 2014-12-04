<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<div>

    <div class="primaryContents myPoint">
        <!-- 마이페이지lnb -->
        <div class="mypage_lnb">
            <h3>포인트</h3>
            <div class="location">
                <span>홈</span> &gt; <span>마이페이지</span> &gt; <span>프로필 관리</span>
            </div>
        </div>
        <!-- //마이페이지lnb -->

        <!-- 내용 -->
        <div class="contBlock">
            <h4>나의 보유 포인트</h4>
            <div class="totalPoint">
                    <span class="count">
                        0
                        P</span>
            </div>

            <h4>나의 포인트 내역</h4>
            <!-- 게시판영역 -->
            <div class="boardSection">
                <table cellpadding="0" cellspacing="0">
                    <colgroup>
                        <col width="125px" />
                        <col width="*" />
                        <col width="110px" />
                        <col width="110px" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col">
                            <div class="th">날짜</div>
                        </th>
                        <th scope="col">
                            <div class="th">내역</div>
                        </th>
                        <th scope="col">
                            <div class="th">받은포인트</div>
                        </th>
                        <th scope="col">
                            <div class="th">사용포인트</div>
                        </th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <div class="seeMore">
                    <a href="">더보기</a>
                </div>
            </div>
            <!-- //게시판영역 -->
        </div>
        <!-- //내용 -->
    </div>

</div>



</body>
</html>