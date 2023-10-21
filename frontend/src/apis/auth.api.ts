import http from 'src/utils/http'

export const URL_LOGIN = 'auth/authenticate'
export const URL_REGISTER = 'auth/register'
export const URL_LOGOUT = 'auth/logout'

const authApi = {
  registerAccount(body: { username: string; password: string }) {
    return http.post(URL_REGISTER, body)
  },

  loginAccount(body: { username: string; password: string }) {
    return http.post(URL_LOGIN, body)
  }
}

export default authApi
