package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//Filter
//���ʹ� �� ���ø����̼ǿ��� ����ϴ� �����̳� jsp�� �����ϱ� ����
//request�� ������ ������ �� �����̳� jsp�� ������ ��Ȱ�� �Ѵ�.
//�ַ� ������ ���� ����ϰ� ��û������ �α����Ϸ� �ۼ�, ���ڵ� �۾�,
//�α������� ���ϸ� ī�信 �������� ���ϰ� �ϴ� ���.

public class TimerFilter implements Filter {

	private FilterConfig config;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		long before = System.currentTimeMillis();

		chain.doFilter(request, response);// �������� �����͸� ����		chain �۾��� �ؾ����� ���͸� ��ģ �Ŀ��� �����

		long after = System.currentTimeMillis();

		String uri;

		if (request instanceof HttpServletRequest) {

			HttpServletRequest req = (HttpServletRequest) request;

			uri = req.getRequestURI();

			// ������ ���� �ð�
			//config.getServletContext().log(uri + ":" + (after - before) + "ms");// �α����� �����
			System.out.println(uri + ":" + (after - before) + "ms");								

		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

		this.config = config;
	}
}

























