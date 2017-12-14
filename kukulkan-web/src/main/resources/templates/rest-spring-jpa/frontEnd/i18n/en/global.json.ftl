{
    "global": {
        "title": "${projectName}",
        "browsehappy": "You are using an <strong>outdated</strong> browser. Please <a href=\"http://browsehappy.com/?locale=en\">upgrade your browser</a> to improve your experience.",
        "menu": {
            "home": "Home",
            "jhipster-needle-menu-add-element": "JHipster will add additional menu entries here (do not translate!)",
            "entities": {
                "main": "Entities",
                <#list dataModelGroup as dmg>
					<#list dmg.domainModelElements as dme>
					"${dme.camelCaseFormat}": "${dme.name}",
					</#list>    
				</#list>
                "jhipster-needle-menu-add-entry": "JHipster will add additional entities here (do not translate!)"
            },
            "account": {
                "main": "Account",
                "settings": "Settings",
                "password": "Password",
                "sessions": "Sessions",
                "login": "Sign in",
                "logout": "Sign out",
                "register": "Register"
            },
            "admin": {
                "main": "Administration",
                "userManagement": "User management",
                "tracker": "User tracker",
                "metrics": "Metrics",
                "health": "Health",
                "configuration": "Configuration",
                "logs": "Logs",
                "audits": "Audits",
                "apidocs": "API",
                "database": "Database",
                "jhipster-needle-menu-add-admin-element": "JHipster will add additional menu entries here (do not translate!)"
            },
            "language": "Language"
        },
        "form": {
            "username": "Username",
            "username.placeholder": "Your username",
            "newpassword": "New password",
            "newpassword.placeholder": "New password",
            "confirmpassword": "New password confirmation",
            "confirmpassword.placeholder": "Confirm the new password",
            "email": "Email",
            "email.placeholder": "Your email"
        },
        "messages": {
            "info": {
                "authenticated": "If you want to <a class=\"alert-link\" href=\"\" ng-click=\"vm.login()\">sign in</a>, you can try the default accounts:<br/>- Administrator (login=\"admin\" and password=\"admin\") <br/>- User (login=\"user\" and password=\"user\").",
                "register": "You don't have an account yet? <a class=\"alert-link\" href=\"\" ng-click=\"vm.register()\">Register a new account</a>"
            },
            "error": {
                "dontmatch": "The password and its confirmation do not match!"
            },
            "validate": {
                "newpassword": {
                    "required": "Your password is required.",
                    "minlength": "Your password is required to be at least 4 characters.",
                    "maxlength": "Your password cannot be longer than 50 characters.",
                    "strength": "Password strength:"
                },
                "confirmpassword": {
                    "required": "Your confirmation password is required.",
                    "minlength": "Your confirmation password is required to be at least 4 characters.",
                    "maxlength": "Your confirmation password cannot be longer than 50 characters."
                },
                "email": {
                    "required": "Your email is required.",
                    "invalid": "Your email is invalid.",
                    "minlength": "Your email is required to be at least 5 characters.",
                    "maxlength": "Your email cannot be longer than 50 characters."
                }
            }
        },
        "field": {
            "id": "ID"
        },
        "ribbon": {
            "dev":"Development"
        },
        "item-count": "Showing {{first}} - {{second}} of {{total}} items."
    },
    "entity": {
        "action": {
            "addblob": "Add blob",
            "addimage": "Add image",
            "back": "Back",
            "cancel": "Cancel",
            "delete": "Delete",
            "edit": "Edit",
            "open": "Open",
            "save": "Save",
            "view": "View"
        },
        "detail": {
            "field": "Field",
            "value": "Value"
        },
        "delete": {
            "title": "Confirm delete operation"
        },
        "validation": {
            "required": "This field is required.",
            "minlength": "This field is required to be at least {{ min }} characters.",
            "maxlength": "This field cannot be longer than {{ max }} characters.",
            "min": "This field should be at least {{ min }}.",
            "max": "This field cannot be more than {{ max }}.",
            "minbytes": "This field should be at least {{ min }} bytes.",
            "maxbytes": "This field cannot be more than {{ max }} bytes.",
            "pattern": "This field should follow pattern for {{ pattern }}.",
            "number": "This field should be a number.",
            "datetimelocal": "This field should be a date and time."
        }
    },
    "error": {
        "internalServerError": "Internal server error",
        "server.not.reachable": "Server not reachable",
        "url.not.found": "Not found",
        "NotNull": "Field {{ fieldName }} cannot be empty!",
        "Size": "Field {{ fieldName }} does not meet min/max size requirements!",
        "userexists": "Login name already used!",
        "emailexists": "Email is already in use!",
        "idexists": "A new {{ entityName }} cannot already have an ID"
    },
    "footer": "This is your footer"
}