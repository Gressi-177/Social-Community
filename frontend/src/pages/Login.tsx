import { faArrowLeft } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import Authentication from 'layouts/Authentication'
import { Link } from 'react-router-dom'

function Login() {
  return (
    <Authentication>
      <div className='flex items-center justify-center flex-col w-full h-full'>
        <main className=''>
          <div className='logo text-center flex items-center'>
            <img src='https://pixner.net/circlehub/main/assets/images/logo.png' alt='logo' className='mx-auto' />
          </div>

          <div className='title my-16'>
            <h3 className='font-bold text-2xl capitalize text-center'>Welcome!</h3>
          </div>
          <form className='px-40'>
            <input
              className='w-full border-gray-200 border p-3 outline-none rounded-lg'
              type='text'
              id='username'
              name='username'
              placeholder='Nhập tên người dùng'
              required
            />

            <input
              className='w-full border-gray-200 border p-3 outline-none rounded-lg mt-6'
              type='password'
              id='password'
              name='password'
              placeholder='Nhập mật khẩu'
              required
            />

            <button type='submit' className='bg-primaryButton w-full mt-10 rounded-lg p-3 font-bold text-lg text-white'>
              Gửi
            </button>
            <div className='mt-2 w-full text-center'>
              <Link to='forgot-pass' className='italic underline '>
                Forgot password
              </Link>
            </div>
            <div className='flex justify-between mt-2'>
              <Link to='register' className='italic underline'>
                Register here
              </Link>
              <Link to='/' className='italic underline'>
                {' '}
                <FontAwesomeIcon icon={faArrowLeft} /> Back to Linh-Doan
              </Link>
            </div>
          </form>
        </main>
      </div>
    </Authentication>
  )
}

export default Login
