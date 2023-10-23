;;; Sierra Script 1.0 - (do not remove this comment)
(script# 400)
(include sci.sh)
(use Main)
(use LLRoom)
(use n958)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm400 0
)

(local
	local0
	local1
	local2
)
(instance rm400 of LLRoom
	(properties
		picture 400
		east 405
		west 410
	)
	
	(method (init)
		(proc958_0 128 400 401)
		(proc958_0 132 401 402 403 404)
		(gLarry init:)
		(proc0_2)
		(switch gGNumber
			(east
				(gLarry posn: 285 100 normalize: 570)
				(gLarry setScript: sFromManager)
			)
			(else 
				(gLongSong stop:)
				(gLongSong2 stop:)
				(self style: 9)
				(gLarry loop: 3 cel: 2 posn: 195 96 normalize: 401)
				(gLarry setScript: sToManager)
			)
		)
		(super init:)
		(proc0_13 430)
	)
	
	(method (doit)
		(super doit:)
		(if (gLarry mover?)
			(switch (gLarry cel?)
				(0
					(if (== (stepSound number?) 404)
						(stepSound number: 402 play:)
					else
						(stepSound number: (+ (stepSound number?) 1) play:)
					)
				)
				(4
					(if (== (stepSound number?) 404)
						(stepSound number: 402 play:)
					else
						(stepSound number: (+ (stepSound number?) 1) play:)
					)
				)
			)
		)
	)
	
	(method (dispose)
		(gLongSong fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance patrons of Prop
	(properties
		x 183
		y 81
		view 400
		cycleSpeed 18
	)
	
	(method (doit)
		(cond 
			((< local2 4)
				(if (== (self cel?) 1)
					(if (not local1)
						(gLongSong number: 401 flags: 1 loop: 0 play:)
						(++ local2)
						(= local1 1)
					)
				else
					(= local1 0)
				)
			)
			((== local2 4) (self setCycle: 0 stopUpd:))
		)
		(super doit:)
	)
)

(instance stepSound of Sound
	(properties
		number 404
	)
)

(instance sToManager of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(patrons init: setCycle: Fwd)
				(gLarry setLoop: 0 setCycle: End self cycleSpeed: 12)
			)
			(1 (gLarry setCycle: Beg self))
			(2
				(gLarry view: 570 setLoop: 8 setCel: 6)
				(= seconds 4)
			)
			(3
				(proc0_18 gLarry 400 0 67 -1 15 70 280)
				(= ticks 30)
			)
			(4
				(proc0_18 gLarry 400 1 67 -1 15 70 280)
				(= ticks 30)
			)
			(5
				(proc0_18 gLarry 400 2 67 -1 15 70 280)
				(= seconds 3)
			)
			(6
				(proc0_14 400 3 67 -1 185)
				(= seconds 3)
			)
			(7
				(proc0_18 gLarry 400 4 67 -1 15 70 280)
				(gLarry
					normalize:
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 270 95 self
				)
			)
			(8
				(proc0_18 gLarry 400 5)
				(proc0_14 400 6 67 -1 185)
				(global2 newRoom: (global2 east?))
			)
		)
	)
)

(instance sFromManager of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 160 100 self
				)
			)
			(1
				(proc0_18 gLarry 400 7)
				(gLarry setMotion: MoveTo 32 100 self)
			)
			(2
				(proc0_14 400 8)
				(global2 newRoom: (global2 west?))
			)
		)
	)
)
