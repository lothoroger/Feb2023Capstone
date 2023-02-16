package com.fds.FoodDelivery.model;


import java.util.List;

public class Response<T> {

		Integer code;
		String message;
		List<T> data;
	

		public Response() {
		}

		public Response(Integer code, String message) {
			this.code = code;
			this.message = message;
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

		public List<T> getUser() {
			return data;
		}

		public void setUser(List<T> data) {
			this.data = data;
		}

		public  List<T>  getCuisines() {
			return data;
		}

	
		public void setCuisines(List<T> data) {
				this.data = data;
			}
		
		
		public Response(int code, String message, List<T> data) {
			// TODO Auto-generated constructor stub
			this.message = message;
			this.data = data;
			this.code = code;
			System.out.print(code);
			System.out.print(' '+message);
			System.out.print(data);
		}

		@Override
		public String toString() {
			return "Response [code=" + code + ", "+" message=" + message + "]";
		}

	}
