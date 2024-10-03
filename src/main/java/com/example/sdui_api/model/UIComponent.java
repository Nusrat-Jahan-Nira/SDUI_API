// package com.example.sdui_api.model;

// import java.util.List;
// import java.util.Objects;

// public class UIComponent {
//     private String type;                 // The type of component (e.g., "text", "button", etc.)
//     private String label;                // The label for the component (e.g., "Username", "Login")
//     private String placeholder;          // Placeholder text for inputs
//     private String action;               // Action for buttons (e.g., "submit")
//     private List<UIComponent> children;  // For nested components (if any)

//     // Default constructor
//     public UIComponent() {
//     }

//     // Constructor with parameters
//     public UIComponent(String type, String label, String placeholder, String action, List<UIComponent> children) {
//         this.type = type;
//         this.label = label;
//         this.placeholder = placeholder;
//         this.action = action;
//         this.children = children;
//     }

//     // Getters
//     public String getType() {
//         return type;
//     }

//     public String getLabel() {
//         return label;
//     }

//     public String getPlaceholder() {
//         return placeholder;
//     }

//     public String getAction() {
//         return action;
//     }

//     public List<UIComponent> getChildren() {
//         return children;
//     }

//     // Setters
//     public void setType(String type) {
//         this.type = type;
//     }

//     public void setLabel(String label) {
//         this.label = label;
//     }

//     public void setPlaceholder(String placeholder) {
//         this.placeholder = placeholder;
//     }

//     public void setAction(String action) {
//         this.action = action;
//     }

//     public void setChildren(List<UIComponent> children) {
//         this.children = children;
//     }

//     // Override toString
//     @Override
//     public String toString() {
//         return "UIComponent{" +
//                 "type='" + type + '\'' +
//                 ", label='" + label + '\'' +
//                 ", placeholder='" + placeholder + '\'' +
//                 ", action='" + action + '\'' +
//                 ", children=" + children +
//                 '}';
//     }

//     // Override equals
//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (!(o instanceof UIComponent)) return false;
//         UIComponent that = (UIComponent) o;
//         return Objects.equals(type, that.type) &&
//                 Objects.equals(label, that.label) &&
//                 Objects.equals(placeholder, that.placeholder) &&
//                 Objects.equals(action, that.action) &&
//                 Objects.equals(children, that.children);
//     }

//     // Override hashCode
//     @Override
//     public int hashCode() {
//         return Objects.hash(type, label, placeholder, action, children);
//     }
// }
package com.example.sdui_api.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.sdui_api.model.UIComponent.ActionDetails;

// public class UIComponent {
//     private String type; // e.g., "text", "button", "dropdown"
//     private String label; // Display label
//     private String placeholder; // Placeholder for input fields
//     private ActionDetails actionDetails; // Details for the action to be taken
//     private List<String> options; // Options for dropdowns

//     // Getters and Setters
//     public String getType() {
//         return type;
//     }

//     public void setType(String type) {
//         this.type = type;
//     }

//     public String getLabel() {
//         return label;
//     }

//     public void setLabel(String label) {
//         this.label = label;
//     }

//     public String getPlaceholder() {
//         return placeholder;
//     }

//     public void setPlaceholder(String placeholder) {
//         this.placeholder = placeholder;
//     }

//     public ActionDetails getActionDetails() {
//         return actionDetails;
//     }

//     public void setActionDetails(ActionDetails actionDetails) {
//         this.actionDetails = actionDetails;
//     }

//     public List<String> getOptions() {
//         return options;
//     }

//     public void setOptions(List<String> options) {
//         this.options = options;
//     }

//     @Override
//     public String toString() {
//         return "UIComponent{" +
//                 "type='" + type + '\'' +
//                 ", label='" + label + '\'' +
//                 ", placeholder='" + placeholder + '\'' +
//                 ", actionDetails=" + actionDetails +
//                 ", options=" + options +
//                 '}';
//     }

//     // Inner class to hold action details
//     public static class ActionDetails {
//         private String url; // API endpoint
//         private String method; // HTTP method (GET/POST)
//         private String successMessage; // Message on success
//         private String errorMessage; // Message on error

//         // Getters and Setters
//         public String getUrl() {
//             return url;
//         }

//         public void setUrl(String url) {
//             this.url = url;
//         }

//         public String getMethod() {
//             return method;
//         }

//         public void setMethod(String method) {
//             this.method = method;
//         }

//         public String getSuccessMessage() {
//             return successMessage;
//         }

//         public void setSuccessMessage(String successMessage) {
//             this.successMessage = successMessage;
//         }

//         public String getErrorMessage() {
//             return errorMessage;
//         }

//         public void setErrorMessage(String errorMessage) {
//             this.errorMessage = errorMessage;
//         }

//         @Override
//         public String toString() {
//             return "ActionDetails{" +
//                     "url='" + url + '\'' +
//                     ", method='" + method + '\'' +
//                     ", successMessage='" + successMessage + '\'' +
//                     ", errorMessage='" + errorMessage + '\'' +
//                     '}';
//         }
//     }
// }

public class UIComponent {
    private String type; // e.g., "text", "button", "dropdown"
    private String label; // Display label
    private String placeholder; // Placeholder for input fields
    private String value; // Value for the input or selected option
    private ActionDetails actionDetails; // Details for the action to be taken
    private List<String> options; // Options for dropdowns
    private List<UIComponent> children; 
 
    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<UIComponent>  getChildren() {
        return children;
    }

    public void setChildren(List<UIComponent>  children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ActionDetails getActionDetails() {
        return actionDetails;
    }

    public void setActionDetails(ActionDetails actionDetails) {
        this.actionDetails = actionDetails;
    }

    public List<String> getOptions() {
        return options;
    }
    public boolean isLabel() {
        return "Label".equalsIgnoreCase(type);
    }

    // public boolean isCard() {
    //     return "Card".equalsIgnoreCase(type);
    // }
    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "UIComponent{" +
                "type='" + type + '\'' +
                ", label='" + label + '\'' +
                ", placeholder='" + placeholder + '\'' +
                ", value='" + value + '\'' +
                ", actionDetails=" + actionDetails +
                ", options=" + options +
                '}';
    }

    // Inner class to hold action details
    public static class ActionDetails {
        private String url; // API endpoint
        private String method; // HTTP method (GET/POST)
        private String successMessage; // Message on success
        private String errorMessage; // Message on error

        // Getters and Setters
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getSuccessMessage() {
            return successMessage;
        }

        public void setSuccessMessage(String successMessage) {
            this.successMessage = successMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public String toString() {
            return "ActionDetails{" +
                    "url='" + url + '\'' +
                    ", method='" + method + '\'' +
                    ", successMessage='" + successMessage + '\'' +
                    ", errorMessage='" + errorMessage + '\'' +
                    '}';
        }

    }
}
