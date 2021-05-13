# -*- encoding: utf-8 -*-
"""
Copyright (c) 2019 - present AppSeed.us
"""

from app.base import constants
from app.home import blueprint
from app.base.routes import requires_auth_seller, requires_auth_user, requires_auth
from flask import render_template, redirect, url_for, request, session

@blueprint.route('/index')
@requires_auth
def index():

    return render_template('index.html', segment='index', userinfo=session[constants.PROFILE_KEY])


@blueprint.route('/order')
@requires_auth_user
def order():

    return render_template('order.html', segment='order', userinfo=session[constants.PROFILE_KEY])


@blueprint.route('/order-tables')
@requires_auth_seller
def order_tables():

    return render_template('order-tables.html', segment='tables', userinfo=session[constants.PROFILE_KEY])


@blueprint.route('/profile')
@requires_auth
def profile():
    return render_template('profile.html', segment='profile', userinfo=session[constants.PROFILE_KEY])

