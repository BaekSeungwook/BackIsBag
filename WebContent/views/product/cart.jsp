<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Cart</title>
<meta content="" name="description" />
<meta content="" name="keywords" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta content="telephone=no" name="format-detection" />
<meta name="HandheldFriendly" content="true" />
<link rel="stylesheet" href="assets/css/master.css" />
<link rel="icon" type="image/x-icon" href="favicon.ico" />
<!--[if lt IE 9 ]>
<script src="assets/js/separate-js/html5shiv-3.7.2.min.js" type="text/javascript"></script><meta content="no" http-equiv="imagetoolbar">
<![endif]-->
</head>
<body>
	<c:set var="path" value="${pageContext.request.contextPath}"
		scope="application" />



	<%-- <c:otherwise>
		<c:forEach items="${requestScope.list}" var="elecDto">
			<tr onmouseover="this.style.background='#eaeaea'"
				onmouseout="this.style.background='white'">
				<td bgcolor="">
					<p align="center">
						<span style="font-size: 9pt;"> ${elecDto.modelNum}</span>
					</p>
				</td>
				<td bgcolor="">
					<p>
						<span style="font-size: 9pt;"> <a
							href="elec?command=read&modelNum=${elecDto.modelNum}">
								${elecDto.modelName} </a>
						</span>
					</p>
				</td>

				<td bgcolor="">
					<p align="center">
						<span style="font-size: 9pt;"> <fmt:formatNumber
								value="${elecDto.price}" /></span>
					</p>
				</td>
				<td bgcolor="">
					<p align="center">
						<span style="font-size: 9pt;"> ${elecDto.writeday}</span>
					</p>
				</td>

				<td bgcolor="">
					<p align="center">
						<span style="font-size: 9pt;"> ${elecDto.fName}</span>
					</p>
				</td>
				<td bgcolor="">
					<p align="center">
						<span style="font-size: 9pt;"> <fmt:formatNumber
								value="${elecDto.fSize}" /> byte
						</span>
					</p>
				</td>
				<td bgcolor="">
					<p align="center">
						<span style="font-size: 9pt;"> ${elecDto.readnum}</span>
					</p>
				</td>
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose> --%>

	<div class="l-main-content l-main-content_w-border">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">

					<div class="section-title-page section-title-page_mod-a">
						<h1 class="ui-title-page"><b>Shopping Cart</b></h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="woocommerce">
						<form action="" method="post" class="cart-table">
							<div class="b-table b-cart-table"
								style="margin: 0 auto; width: 90%;">
								<table class="shop_table shop_table_responsive cart table"
									cellspacing="0">
									<thead>
										<tr>
											<td class="product-thumbnail"><span>Image</span></td>
											<td class="product-name"><span>Product</span></td>
											<td class="product-price"><span>Price</span></td>
											<td class="product-quantity"><span>Quantity</span></td>
											<td class="product-subtotal"><span>Total</span></td>
											<td class="product-remove"><span>remove</span></td>
											<input type="hidden" name="id" value=""> <!-- 회원아이디 정보 -->
										</tr>
									</thead>
									<tbody>


								<%-- 		<c:choose>
											<c:when test="${empty requestScope.list}">
												<tr class="cart_item">
													<td colspan="6"><span>등록된 상품이 없습니다.</span></td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach items="${requestScope.list}" var="cartDto"> --%>
													<tr class="cart_item">
														<td class="product-thumbnail"><a
															href="catalog-product.html"> <img width="180"
																height="180" src="save/펜톤가방.jpg"
																class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image">
														</a></td>

														<td data-title="Product">
															<div class="caption">
																<a class="product-name" href="${path}/product?command=productread&proCode=48">펜톤가방</a>
															</div>
														</td>

														<td class="product-price" data-title="Price">
														<span class="product-price total-price"> 
														  <span class="woocommerce-Price-amount amount">
														    <span class="woocommerce-Price-currencySymbol">
														      &#8361 27,000</span></span>
														</span></td>

														<td class="product-quantity" data-title="Quantity">

															<div class="input-group btn-block qty-block"
																data-trigger="spinner">


																<input type="text" data-rule="quantity"
																	value="2" title="Qty"
																	class="input-text qty text">

															</div>


														</td>

														<td class="product-subtotal" data-title="Total"><span
															class="woocommerce-Price-amount amount"><span
																class="woocommerce-Price-currencySymbol">&#8361</span>54,000</span></td>
														<td class="product-remove"><a href="/"
															class="btn btn-remove" title="Remove this item"><i
																class="fa fa-trash fa-lg"></i></a></td>
													</tr>
										<%-- 		</c:forEach>
											</c:otherwise>
										</c:choose> --%>
										<tr>
											<td colspan="6" class="actions"><input type="submit"
												class="button" name="update_cart" value="Update Cart"
												disabled=""> <input type="hidden" value="6bbd62fad3"><input
												type="hidden"></td>
										</tr>

									</tbody>
								</table>
							</div>


						</form>

						<div class="cart-collaterals">

							<div class="cart_totals calculated_shipping">


								<h2>Cart Totals</h2>

								<table cellspacing="0" class="shop_table shop_table_responsive">

									<tbody>
										<tr class="cart-subtotal">
											<th>Subtotal</th>
											<td data-title="Subtotal"><span
												class="woocommerce-Price-amount amount"><span
													class="woocommerce-Price-currencySymbol">&#8361</span>875.00</span></td>
										</tr>






										<tr class="order-total">
											<th>Total</th>
											<td data-title="Total"><strong><span
													class="woocommerce-Price-amount amount"><span
														class="woocommerce-Price-currencySymbol">&#8361</span>875.00</span></strong></td>
										</tr>


									</tbody>
								</table>

								<div class="wc-proceed-to-checkout">

									<a href="checkout.html"
										class="checkout-button button alt wc-forward"> Proceed to
										Checkout</a>
								</div>


							</div>

						</div>

					</div>






				</div>


			</div>
		</div>
	</div>

	<script src="assets/libs/jquery-1.12.4.min.js"></script>
	<script src="assets/libs/jquery-migrate-1.2.1.js"></script>
	<script src="assets/libs/modernizr.custom.js"></script>
	<!-- Bootstrap-->
	<script src="assets/libs/bootstrap/bootstrap.min.js"></script>
	<!-- User customization-->
	<script src="assets/js/custom.js"></script>
	<!-- Select customization & Color scheme-->
	<script
		src="assets/plugins/bootstrap-select/js/bootstrap-select.min.js"></script>

</body>
</html>