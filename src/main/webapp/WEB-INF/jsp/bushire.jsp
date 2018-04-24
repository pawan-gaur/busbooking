<%@ include file="common/header.jsp"%>

<div class="container">
	<div class="col-md-5 bann-info1 wow fadeInLeft animated"
		data-wow-delay=".5s">
		<i class="fa fa-th-large" style="font-size: 9em; color: #1f8dd6;"></i>
		<h3>INDIA MOST TRUSTED SERVICE</h3>
	</div>
	<div class="col-md-7 bann-info wow fadeInRight animated"
		data-wow-delay=".5s">
		<h2>Hire Bus at Minimal Advance Booking Fee</h2>
		<div class="ban-top">
			<div class="bnr-left">
				<label class="inputLabel">From</label> <input class="city"
					type="text" value="Enter a city" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Enter a city';}"
					required=>
			</div>
			<div class="bnr-left">
				<label class="inputLabel">To</label> <input class="city" type="text"
					value="Enter a city" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Enter a city';}"
					required=>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="ban-bottom">
			<div class="bnr-right">
				<label class="inputLabel">Date of Journey</label> <input
					class="date" id="datepicker" type="text" value="dd-mm-yyyy"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'dd-mm-yyyy';}"
					required=>
			</div>
			<div class="bnr-right">
				<label class="inputLabel">Date of Return<span class="opt">&nbsp;(Optional)</span></label>
				<input class="date" id="datepicker1" type="text" value="dd-mm-yyyy"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'dd-mm-yyyy';}"
					required=>
			</div>
			<div class="clearfix"></div>
			<!---start-date-piker---->
			<link rel="stylesheet" href="static/css/jquery-ui.css" />
			<script src="static/js/jquery-ui.js"></script>
			<script>
				$(function() {
					$("#datepicker,#datepicker1").datepicker();
				});
			</script>
			<!---/End-date-piker---->
		</div>
		
		<div class="ban-bottom">
			<div class="bnr-left">
				<label class="inputLabel">Total Person</label> <input class="city"
					type="text" value="Enter No. of Person" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Enter No. of Person';}"
					required=>
			</div>
			<div class="clearfix"></div>
		</div>
		
		<div class="sear">
			<form action="bus.html">
				<button class="seabtn">Hire Bus</button>
			</form>
		</div>
	</div>
	<div class="clearfix"></div>
</div>

<%@ include file="common/footer.jsp"%>