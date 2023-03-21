(ns calculators.core
  (:require [reagent.dom :as rdom]
            [calculators.routes :as routes]))

(defn ^:dev/after-load start []
  (routes/init-router)
  (rdom/render [routes/current-page] 
               (.getElementById js/document "app")))

(defn ^:export main []
  (start))
