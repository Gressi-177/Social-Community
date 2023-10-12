import { ReactNode } from 'react'

interface AuthenticationProps {
  children: ReactNode
}

function Authentication({ children }: AuthenticationProps) {
  return (
    <div className='flex'>
      <div
        className='w-1/2 h-[100vh] relative flex items-center justify-center'
        style={{
          backgroundImage: `url('https://odindesignthemes.com/vikinger-theme/wp-content/themes/vikinger/img/login/background.jpg')`,
          backgroundRepeat: 'no-repeat',
          backgroundSize: 'cover',
          backgroundPosition: 'center center'
        }}
      >
        <div className='absolute text-center'>
          <h3 className='text-white font-bold text-3xl capitalize'>Welcome to</h3>
          <h1 className='text-white font-extrabold text-7xl uppercase'>Linh-Doan</h1>
          <p className='text-white text-lg capitalize mt-8 max-w-[400px]'>
            <b>The next generation WordPress+Buddypress social community!</b> Connect with your friends with full
            profiles, reactions, groups, badges, quests, ranks, credits and much more to come!
          </p>
        </div>
      </div>
      <div className='w-1/2 h-[100vh] bg-white '>{children}</div>
    </div>
  )
}

export default Authentication
