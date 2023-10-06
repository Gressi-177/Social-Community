import React, { ReactNode } from 'react'
import Header from 'components/Header'
import Footer from 'components/Footer'
import NavSidebar from 'components/NavSidebar'
import WritePost from 'components/WritePost'
import Post from 'components/Post'

interface DefaultLayoutProps {
  children: ReactNode
}

function DefaultLayout({ children }: DefaultLayoutProps) {
  return (
    <>
      <Header />
      <div className='main bg-background p-3 h-screen flex'>
        <NavSidebar />
        <div className='w-1/4'></div>
        <main className='bg-gray-200 w-1/2 mt-20 mx-5'>
          <WritePost />
          <Post />
          <Post />
        </main>
      </div>
      {children}
      <Footer />
    </>
  )
}

export default DefaultLayout
