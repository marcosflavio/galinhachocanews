package br.ufc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class GeneralInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String URI = request.getRequestURI();

		if (URI.endsWith("loginForm") || URI.endsWith("tentativaLogin") || URI.endsWith("logout") || URI.endsWith("/")
				|| URI.endsWith("showNewsInSection") || URI.endsWith("showNewsForm") || URI.endsWith("listAdsUser")
				|| URI.endsWith("showAdsForm")|| URI.endsWith("showUserForm")) {
			return true;
		}

		else if (URI.endsWith("loginForm") || URI.endsWith("tentativaLogin") || URI.endsWith("logout")) {
			return true;
		}

		else if ((URI.endsWith("login") || URI.endsWith("insertRoleForm") || URI.endsWith("insertRole")
				|| URI.endsWith("removeRole") || URI.endsWith("updateRoleForm") || URI.endsWith("updateRole")
				|| URI.endsWith("listRole") || URI.endsWith("insertUserForm") || URI.endsWith("insertUser")
				|| URI.endsWith("updateUserForm") || URI.endsWith("updateUser") || URI.endsWith("removeUser")
				|| URI.endsWith("listUser") || URI.endsWith("showUserForm") || URI.endsWith("showUser")
				|| URI.endsWith("insertSectionForm") || URI.endsWith("insertSection") || URI.endsWith("removeSection")
				|| URI.endsWith("updateSectionForm") || URI.endsWith("updateSection") || URI.endsWith("listSection")
				|| URI.endsWith("insertAdsForm") || URI.endsWith("insertAds") || URI.endsWith("listAds")
				|| URI.endsWith("removeAds") || URI.endsWith("updateAdsForm") || URI.endsWith("updateAds")
				|| URI.endsWith("showNewsInSection") || URI.endsWith("showNewsForm") || URI.endsWith("/"))
				&& request.getSession().getAttribute("user_logged_editor") != null) {

			return true;
		}

		else if ((URI.endsWith("login") || URI.endsWith("insertRoleForm") || URI.endsWith("insertRole")
				|| URI.endsWith("removeRole") || URI.endsWith("updateRoleForm") || URI.endsWith("updateRole")
				|| URI.endsWith("listRole") || URI.endsWith("insertUserForm") || URI.endsWith("insertUser")
				|| URI.endsWith("updateUserForm") || URI.endsWith("updateUser") || URI.endsWith("removeUser")
				|| URI.endsWith("listUser") || URI.endsWith("showUserForm") || URI.endsWith("showUser")
				|| URI.endsWith("insertSectionForm") || URI.endsWith("insertSection") || URI.endsWith("removeSection")
				|| URI.endsWith("updateSectionForm") || URI.endsWith("updateSection") || URI.endsWith("listSection")
				|| URI.endsWith("insertAdsForm") || URI.endsWith("insertAds") || URI.endsWith("listAds")
				|| URI.endsWith("removeAds") || URI.endsWith("updateAdsForm") || URI.endsWith("updateAds")
				|| URI.endsWith("showNewsInSection") || URI.endsWith("showNewsForm") || URI.endsWith("/"))
				&& request.getSession().getAttribute("user_logged_adm") != null) {

			return true;

		} else if (URI.endsWith("login") || URI.endsWith("insertNewsForm") || URI.endsWith("insertNews")
				|| URI.endsWith("listNews") || URI.endsWith("removeNews") || URI.endsWith("updateNews")
				|| URI.endsWith("updateNewsForm") || URI.endsWith("showNewsInSection") || URI.endsWith("showNewsForm")
				|| URI.endsWith("/") && request.getSession().getAttribute("user_logged_journalist") != null) {

			return true;
		}

		else {

			response.sendRedirect("loginForm");
			return false;
		}
	}
}
