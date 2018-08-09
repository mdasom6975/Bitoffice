<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>


	<div class="col-md-10" >
		 <div class="tile">
		 <h3 class="tile-title" >공지사항 상세보기</h3>
		 <!-- START PrinArea -->
		 <div id="printArea">
			<table class="table" >
				<thead>
				
					<tr>
						<th>글제목</th>
						<th>${board.boardTitle}</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>작성자</td>
						<td  id= "getEmployee" value="${board.employeeNo}">${board.employeeName}</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td>${board.boardDate}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>${board.boardContent}</td>
					</tr>
					
				</tbody>
			</table>
			</div>
			<!-- END PrinArea -->
			<div class="col-md-12 text-center">
			<c:if test="${employee.employeeNo == board.employeeNo}">
			<button type="button" class="btn btn-primary " value="${board.boardNo }">수정</button>
			</c:if>
			<button type="button" class="btn btn-primary ">목록으로</button>
			<button type="button"  class="btn btn-primary" OnClick="print(document.getElementById('printArea').innerHTML)" ><i class="fa fa-print"></i> Print</button>
			</div>
		</div>
	</div>
