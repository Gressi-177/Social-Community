import {
  faBookmark,
  faGear,
  faHome,
  faImages,
  faMedal,
  faStore,
  faThumbsUp,
  faUserGroup,
  faUsers
} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { Link } from 'react-router-dom'
import React, { useState, useEffect } from 'react'
import axios from 'axios'

interface ProfileData {
  id: number
  status: number
  role: string
  username: string
  created_at: string
  updated_at: string
}

function NavSidebar() {
  const baseURL = process.env.REACT_APP_BASE_URL // Replace with your base URL
  const accessControlOrigin = process.env.REACT_APP_ACCESS_CONTROL_ORIGIN

  const [profile, setProfile] = useState<ProfileData | null>(null) // Khởi tạo là null

  useEffect(() => {
    const axiosInstance = axios.create({
      baseURL,
      headers: {
        'Content-Type': 'application/json',
        'ngrok-skip-browser-warning': true,
        'Access-Control-Allow-Origin': accessControlOrigin,
        Authorization: `Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG0yIiwiaWF0IjoxNjk2OTQ1Mjc4LCJleHAiOjE2OTcwMzE2Nzh9.jEXssWei3uv7L-vc8maH7dwmN775acIGkac9L_NpVYk`
      }
    })

    const fetchProfile = async () => {
      try {
        const response = await axiosInstance.get<any>('/api/v1/profile')
        const data = response.data.data
        console.log('data', data)

        setProfile(data) // Đặt giá trị profile từ dữ liệu API
      } catch (err) {
        console.error(err)
      }
    }

    fetchProfile()
  }, [accessControlOrigin, baseURL])

  return (
    <div>
      <div className='bg-primary w-1/4 p-5 rounded-xl h-full overflow-y-auto overflow-x-auto fixed max-h-90vh top-24 left-2 scrollbar-thin scrollbar-thumb-gray-300 scrollbar-track-transparent'>
        <div className='profile pb-5 border-gray-700  border-b'>
          <div className='relative flex'>
            <div className='pr-2'>
              <span className='notification-badge absolute top-[-4px] left-[-6px] w-4 h-4 bg-green-400 rounded-full flex items-center justify-center font-semibold'></span>
              <img src='https://pixner.net/circlehub/main/assets/images/avatar-1.png' alt='' />
            </div>
            <div className='flex flex-col justify-between'>
              <h3 className='font-semibold text-white text-lg'>{profile?.username}</h3>
              <p className='font-medium text-white text-sm'>@{profile?.username}</p>
            </div>
          </div>
        </div>
        <div className='pt-5 mb-5 border-b border-gray-700'>
          <ul>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faHome} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Home</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faUsers} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>People</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faMedal} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Event</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faImages} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Pages</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faUserGroup} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Group</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faStore} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Marketplace</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faBookmark} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Saved</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faThumbsUp} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Favorites</h4>
              </span>
            </Link>
            <Link
              to='/'
              className='flex items-center mb-6 text-white hover:text-blue-500 transition-colors duration-100'
            >
              <span className='w-10'>
                <FontAwesomeIcon icon={faGear} className='text-2xl mr-4' />
              </span>
              <span className='font-semibold'>
                <h4>Settings</h4>
              </span>
            </Link>
          </ul>
        </div>
        <div>
          <h3 className='text-lg font-semibold text-white'>Your Shortcuts</h3>
          <ul>
            <li className='flex items-center py-6'>
              <img
                className='mr-4'
                src='https://pixner.net/circlehub/main/assets/images/shortcuts-1.png'
                alt='shortcut'
              />
              <p className='font-semibold text-white'>Game Community</p>
            </li>
            <li className='flex items-center py-6'>
              <img
                className='mr-4'
                src='https://pixner.net/circlehub/main/assets/images/shortcuts-2.png'
                alt='shortcut'
              />
              <p className='font-semibold text-white'>Pixel Think (Member)</p>
            </li>
            <li className='flex items-center py-6'>
              <img
                className='mr-4'
                src='https://pixner.net/circlehub/main/assets/images/shortcuts-3.png'
                alt='shortcut'
              />
              <p className='font-semibold text-white'>8 Ball Pool</p>
            </li>
            <li className='flex items-center py-6'>
              <img
                className='mr-4'
                src='https://pixner.net/circlehub/main/assets/images/shortcuts-4.png'
                alt='shortcut'
              />
              <p className='font-semibold text-white'>Gembio</p>
            </li>
          </ul>
        </div>
      </div>
    </div>
  )
}

export default NavSidebar
