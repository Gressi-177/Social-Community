/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{ts,tsx}'],
  theme: {
    extend: { 
      colors: {
        primary: '#212F48', // Màu chính 
        background: '#212529',
        secondary: '#2B3B58', // Màu phụ
      },
    }
  },
  plugins: []
}