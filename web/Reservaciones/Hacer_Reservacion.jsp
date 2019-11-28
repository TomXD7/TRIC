<<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file = "../_top.jsp" %>

<div class="col-lg-5  col-md-6 header-right">
							<h4 class="text-white pb-30">Resarva tu auto ahora!</h4>
							<form class="form" role="form" autocomplete="off">
							    <div class="form-group">
							       	<div class="default-select" id="default-select"">
										<select>
											<option value="" disabled selected hidden>Selecciona tu auto</option>
											<option value="1">BMW</option>
											<option value="1">Nissan</option>
											<option value="1">Toyota</option>
										</select>
									</div>
							    </div>
							    <div class="form-group row">
							        <div class="col-md-6 wrap-left">
								       	<div class="default-select" id="default-select"">
											<select>
												<option value="" disabled selected hidden>Pickup</option>
												<option value="1">Seleccionar uno</option>
												<option value="1">Seleccionar dos</option>
												<option value="1">Seleccionar tres</option>
												<option value="1">Seleccionar cuatro</option>
											</select>
										</div>
							        </div>
							        <div class="col-md-6 wrap-right">
										<div class="input-group dates-wrap">                                          
											<input id="datepicker" class="dates form-control" id="exampleAmount" placeholder="Fecha" type="text">                        
											<div class="input-group-prepend">
												<span  class="input-group-text"><span class="lnr lnr-calendar-full"></span></span>
											</div>											
										</div>
							        </div>
							    </div>
							    <div class="form-group row">
							        <div class="col-md-6 wrap-left">
								       	<div class="default-select" id="default-select"">
											<select>
												<option value="" disabled selected hidden>Drop off</option>
												<option value="1">Dejar Uno</option>
												<option value="1">Dejar Dos</option>
												<option value="1">Dejar Tres</option>
												<option value="1">Dejar Cuatro</option>
											</select>
										</div>
							        </div>
							        <div class="col-md-6 wrap-right">
										<div class="input-group dates-wrap">                                              
											<input id="datepicker2" class="dates form-control" id="exampleAmount" placeholder="Fecha" type="text">                        
											<div class="input-group-prepend">
												<span  class="input-group-text"><span class="lnr lnr-calendar-full"></span></span>
											</div>											
										</div>
							        </div>
							    </div>							    
							    <div class="from-group">
							    	<input class="form-control txt-field" type="text" name="name" placeholder="Nombre Completo">
							    	<input class="form-control txt-field" type="email" name="email" placeholder="Email">
							    	<input class="form-control txt-field" type="tel" name="phone" placeholder="Numero de telefono">
							    </div>
							    <div class="form-group row">
							        <div class="col-md-12">
							            <button type="reset" class="btn btn-default btn-lg btn-block text-center text-uppercase">Confirmar reserva de coche</button>
							        </div>
							    </div>
							</form>
						</div>											
					</div>
				</div>					
			</section>
<%@include file = "../_down.jsp" %>
