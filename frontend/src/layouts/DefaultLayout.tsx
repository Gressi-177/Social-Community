import { ReactNode } from 'react'
import Header from 'components/Header'
import Footer from 'components/Footer'
import NavSidebar from 'components/NavSidebar'
import WritePost from 'components/WritePost'
import Post from 'components/Post'
import ContactSidebar from 'components/ContactSidebar'

interface DefaultLayoutProps {
  children: ReactNode
}

function DefaultLayout({ children }: DefaultLayoutProps) {
  return (
    <>
      <Header />
      <div className=' bg-background p-3 h-screen flex'>
        <NavSidebar />
        <div className='w-1/4'></div>

      {children}
        <ContactSidebar />
      </div>
    </>
  )
}

export default DefaultLayout
