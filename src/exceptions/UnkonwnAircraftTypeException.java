/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   UnkonwnAircraftTypeException.java                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tbareich <tbareich@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/04/17 22:55:47 by tbareich          #+#    #+#             */
/*   Updated: 2022/04/17 22:55:48 by tbareich         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package exceptions;

public class UnkonwnAircraftTypeException extends Exception {
	public UnkonwnAircraftTypeException() {
		super("Unkonwn aircraft type.");
	}
}
