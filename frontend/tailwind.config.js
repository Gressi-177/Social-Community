/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{ts,tsx}'],
  theme: {
    extend: { 
      colors: {
        primary: '#212F48', // Màu chính 
        background: '#162134',
        secondary: '#2B3B58', // Màu phụ ', 
        textPlaceholder: '#A6ACB6', 
        primaryButton: '#0085ff',
      },
    }
  },
  plugins: []
}