# Portfolio Frontend Setup Guide

## 🚀 Project Overview

This is a modern, responsive portfolio frontend built with **React**, **Vite**, and **Tailwind CSS**. It connects to your Portfolio API backend to display your professional information, projects, skills, experience, education, and certificates.

## 📋 Prerequisites

- **Node.js** (v14 or higher)
- **npm** or **yarn**
- Backend API running on `http://localhost:8091`

## 📁 Project Structure

```
src/
├── components/          # React components for each section
│   ├── Header.jsx      # Navigation header
│   ├── About.jsx       # About section
│   ├── Skills.jsx      # Skills display
│   ├── Projects.jsx    # Projects showcase
│   ├── Experience.jsx  # Work experience
│   ├── Education.jsx   # Education details
│   ├── Certificates.jsx # Certificates
│   ├── Contact.jsx     # Contact form
│   └── Footer.jsx      # Footer
├── services/
│   └── api.js          # API service functions
├── styles/             # CSS files for styling
│   ├── global.css      # Global styles
│   ├── Header.css
│   ├── About.css
│   ├── Skills.css
│   ├── Projects.css
│   ├── Experience.css
│   ├── Education.css
│   ├── Certificates.css
│   ├── Contact.css
│   └── Footer.css
├── App.jsx             # Main app component
├── main.jsx            # Entry point
└── index.css           # Global stylesheet imports
```

## 🛠️ Installation & Setup

### 1. Install Dependencies
```bash
npm install
```

### 2. Start Development Server
```bash
npm run dev
```

The application will be available at `http://localhost:5173` (Vite default)

### 3. Build for Production
```bash
npm run build
```

### 4. Preview Production Build
```bash
npm run preview
```

## 🔌 API Integration

All API calls are centralized in `src/services/api.js`. The backend URL is configured as:
```javascript
const BASE_URL = 'http://localhost:8091/api';
```

### Available API Endpoints

| Endpoint | Method | Purpose |
|----------|--------|---------|
| `/api/about` | GET | Get about information |
| `/api/skills` | GET | Get all skills |
| `/api/skills/category/:category` | GET | Get skills by category |
| `/api/projects` | GET | Get all projects |
| `/api/experiences` | GET | Get all experiences |
| `/api/education` | GET | Get all education |
| `/api/certificates` | GET | Get all certificates |
| `/api/contact` | POST | Send contact message |

## 🎨 Customization

### Color Scheme

Update the CSS variables in `src/styles/global.css`:

```css
:root {
  --primary-color: #6366f1;        /* Primary blue */
  --secondary-color: #ec4899;      /* Pink accent */
  --accent-color: #f59e0b;         /* Amber accent */
  --text-dark: #1f2937;
  --text-light: #6b7280;
  --bg-light: #f9fafb;
  --bg-white: #ffffff;
}
```

### Fonts

The portfolio uses **Poppins** for general text and **Merriweather** for headings. These are imported from Google Fonts in `global.css`.

### Responsive Design

The portfolio is fully responsive with breakpoints at:
- **Desktop**: 1200px max-width container
- **Tablet**: Adjusted layouts at 768px
- **Mobile**: Full-width with optimized spacing

## 📦 Key Dependencies

- **React**: UI framework
- **Vite**: Build tool and dev server
- **Tailwind CSS**: Utility-first CSS framework
- **PostCSS**: CSS processing

## 🌟 Features

✅ **Fully Responsive** - Works on all device sizes
✅ **Modern Design** - Gradient backgrounds and smooth animations
✅ **API Integration** - Pulls data from backend in real-time
✅ **Smooth Navigation** - Smooth scrolling between sections
✅ **Contact Form** - Integrated contact messaging
✅ **Error Handling** - Graceful error messages for failed API calls
✅ **Loading States** - Visual feedback while fetching data
✅ **SEO Friendly** - Semantic HTML structure

## 🎯 Component Details

### Header
- Sticky navigation bar
- Smooth scroll to sections
- Responsive mobile menu

### About
- Profile image display
- Bio/description text
- Hover animations

### Skills
- Skills grouped by category
- Proficiency progress bars
- Hover effects

### Projects
- Project cards with images
- Technology tags
- Links to GitHub and live demos

### Experience
- Timeline view of work experience
- Company, title, and dates
- Job descriptions

### Education
- Education cards
- Degree, institution, and GPA
- Graduation year display

### Certificates
- Certificate cards with gradient backgrounds
- Issue date and credential links
- Hover animations

### Contact
- Functional contact form
- Success/error messages
- Form validation

## 🐛 Troubleshooting

### API Not Responding
- Ensure backend is running on `http://localhost:8091`
- Check network tab in browser DevTools
- Verify API endpoints are correct

### Styles Not Loading
- Ensure Tailwind CSS is properly configured in `tailwind.config.js`
- Clear browser cache and rebuild: `npm run build`
- Check that all CSS files are imported in `index.css`

### Components Not Displaying Data
- Verify backend is returning data in expected format
- Check browser console for errors
- Use browser DevTools Network tab to inspect API responses

## 📝 Environment Setup

The portfolio uses a single environment configuration. To change the API URL:

Edit `src/services/api.js`:
```javascript
const BASE_URL = 'http://your-api-url:port/api';
```

## 🚀 Deployment

### Deploy to Vercel
```bash
npm run build
# Then connect to Vercel and deploy
```

### Deploy to Netlify
```bash
npm run build
# Deploy the `dist` folder to Netlify
```

### Deploy to GitHub Pages
1. Update `vite.config.js` with your repository name
2. Run `npm run build`
3. Push `dist` folder to GitHub Pages branch

## 📧 Contact & Support

For backend API issues, check the backend repository documentation.

---

**Built with ❤️ using React + Vite + Tailwind CSS**
