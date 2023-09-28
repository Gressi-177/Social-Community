import React, { ReactNode } from 'react'
import Header from 'components/Header'
import Footer from 'components/Footer'
import NavSidebar from 'components/NavSidebar'

interface DefaultLayoutProps {
  children: ReactNode
}

function DefaultLayout({ children }: DefaultLayoutProps) {
  return (
    <>
      <Header />
      <div className='main bg-background p-3 h-screen mt-20' >
        <NavSidebar />
      </div>
      {children}
      <Footer />
    </>
  )
}

export default DefaultLayout
