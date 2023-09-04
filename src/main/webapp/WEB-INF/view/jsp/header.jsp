 <security:authorize access="isAuthenticated()">
        <security:authentication property="principal.username" var="user"/>



        <security:authorize access="hasRole('ADMIN')" >

            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

                <!-- Links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/admin">Admin Panel</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                        <li class="nav-item" >

                            <h2  class=" text-success"> ${user}  </h2>
                        </li>

                </ul>

            </nav>
        </security:authorize>
     <security:authorize access="hasRole('USER')" >
         <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

         <!-- Links -->
         <ul class="navbar-nav">
             <li class="nav-item">
                 <a class="nav-link" href="/">Home</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link" href="/logout">Logout</a>
             </li>

             <li class="nav-item" >

                 <h2  class=" text-success"> User name: ${user}  </h2>
             </li>
         </ul>
         </nav>

     </security:authorize>

 </security:authorize>
<security:authorize access="!isAuthenticated()">

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signup">Signup</a>
            </li>


        </ul>
    </nav>
</security:authorize>
