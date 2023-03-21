module.exports = {
  content: ["./src/**/**/*.cljs", "./src/main/calculators/views.cljs"],
  theme: {
    extend: {},
  },
  variants: {
    extend: {},
  },
  plugins: [require("@tailwindcss/forms")],
};
