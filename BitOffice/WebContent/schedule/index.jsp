<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<script src="/js/schedule.js"></script>

	<div class="app-title">
		<div>
			<h1><i class="app-menu__icon fa fa-calendar"></i>일정관리</h1>		
			<p><span class="label label-warning" style="background-color:#FFBB00">전체공유</span> <span class="label label-primary" style="background-color:#0099ff"> 내일정</span> 
				공유된 임직원의 일정 색상 변경가능합니다</p>
		</div>
	</div>
		    
	<!-- Modal -->
	<div class="modal fade" id="getMessageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Bitoffice</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <form>
		      <div id="modalmessage" class="modal-body">
		       
		      </div>
	      </form>
	      <div class="modal-footer">
	        <button type="button" id="modalClose" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!--//Modal -->

	<div class="row">   
			<div class="container-fluid">
				<div class="row content">	    		
					<div class="col-sm-2">	
							<input type="hidden" name="employeeNo" id="employeeNo" value="${sessionScope.sessionEmployee.employeeNo}">	
				      <!--  table Start /////////////////////////////////////-->
				      <table class="table table-hover table-striped" >
				      
				        <thead>			        
				          <tr>      
				            <th align="left" colspan="2">내가보고싶은일정 / 수락여부</th>           
				          </tr>
				        </thead >
				       
						<tbody id="shareList">
				<!--  		        <div class="input-group" id="cp0">
						          <input type="text" class="form-control" name="title0" id="title0" value="#ABF200">
						          <span class="input-group-addon colorpicker-component"><i id="cp-icon0"></i></span>
						        </div>		 --> 
<!-- 							<div class='input-group' id='cp0'>
							<input type='text' class='form-control' name='colorpick0' id='colorpick0' value='#ABF200'>
							<span class='input-group-addon colorpicker-component'><i id='cp-icon0'></i></span>
							</div> -->
				
				        </tbody> 
				      
				      </table>
		  <!--  table End /////////////////////////////////////-->												
						    <div style="cursor:pointer;color:#0000FF"><span id="allsee" class="badge badge-pill badge-info" style="font-size:13px;">[공유신청펼치기]<span></div>
						    <div id="SimpleJSTree" style="overflow-y: auto; height:600px;"></div>   
							<div id="dvTreeStructure"></div>
	
						    
					</div>
					<div class="col-sm-7" style="background-color:#F6F6F6">
						  <jsp:include page='/schedule/listSchedule.jsp' flush="true"></jsp:include>   
		  			</div>
		  		</div>
			</div>		
		</form>	
	</div>
