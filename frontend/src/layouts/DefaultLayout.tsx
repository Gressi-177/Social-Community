import { ReactNode } from 'react'
import Header from 'components/Header'
import NavSidebar from 'components/NavSidebar'
import ContactSidebar from 'components/ContactSidebar'

interface DefaultLayoutProps {
  children: ReactNode
}

function DefaultLayout({ children }: DefaultLayoutProps) {
  return (
    <>
      <Header />
      <div className=' p-3 flex'>
        <NavSidebar />
        <div className='w-1/4'></div>

        {children}
        <ContactSidebar />
      </div>
    </>
  )
}

export default DefaultLayout
