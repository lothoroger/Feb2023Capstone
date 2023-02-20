package com.fds.FoodDelivery.model;


import java.util.List;

public class Response<T> {

		Integer code;
		String message;
		List<T> data;
		T datat;
		
		
		
		public T getDatat() {
			return datat;
		}
		public void setDatat(T datat) {
			this.datat = datat;
		}

		
		
		public Response(Integer code, String message, List<T> data, T datat) {
			super();
			this.code = code;
			this.message = message;
			this.data = data;
			this.datat = datat;
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public List<T> getData() {
			return data;
		}
		public void setData(List<T> data) {
			this.data = data;
		}
	

		@Override
		public String toString() {
			return "Response [code=" + code + ", message=" + message + ", data=" + data + ", datat=" + datat + "]";
		}
		public Response(Integer code, String message, List<T> data) {
			super();
			this.code = code;
			this.message = message;
			this.data = data;
		}
		
		
		public Response(Integer code, String message, T data) {
			super();
			this.code = code;
			this.message = message;
			this.datat = data;
		}
		
		
		public Response() {
		}
	
	
		}
		
	