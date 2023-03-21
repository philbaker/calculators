(ns calculators.routes
  (:require [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [calculators.views :as views]
            [calculators.routes :as routes]))

(defonce match (r/atom nil))

(def routes
  [["/"
    {:name ::pixel
     :view views/pixel-to-rem-calculator}]
   ["/percentage"
    {:name ::percentage
     :view views/percentage-calculator}]
   ["/color"
    {:name ::color
     :view views/color-calculator}]])

(defn header []
  [:div.px-6
   [:h1.text-2xl.mt-3 "Calculators"]])

(defn active-link [route]
  (when (= (:name (:data @match)) route) "underline"))

(defn current-page []
  [:div
   [header]
   [:ul {:class "p-6 flex space-x-4"}
    [:li 
     [:a 
      {:class (str "text-md text-blue-800 hover:underline " (active-link :calculators.routes/pixel))
       :href (rfe/href ::pixel)} 
      "Pixel"]]
    [:li 
     [:a 
      {:class (str "text-md text-blue-800 hover:underline " (active-link :calculators.routes/percentage))
       :href (rfe/href ::percentage)} 
      "Percentage"]]
    [:li 
     [:a 
      {:class (str "text-md text-blue-800 hover:underline " (active-link :calculators.routes/color))
       :href (rfe/href ::color)} 
      "Colour"]]]
   
   (if @match
     (let [view (:view (:data @match))]
       [view @match]))])

(defn init-router []
  (rfe/start!
    (rf/router routes)
    (fn [m] (reset! match m))
    {:use-fragment true}))
